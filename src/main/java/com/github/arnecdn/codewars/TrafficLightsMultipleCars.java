package com.github.arnecdn.codewars;

public class TrafficLightsMultipleCars {
    public static final char CAR = 'C';
    public static final char ORANGE = 'O';
    public static final char RED = 'R';
    public static final char GREEN = 'G';

    public static String[] trafficLights(String road, int n) {
        DriveMachine driveMachine = new DriveMachine(road, n);
        return driveMachine.run();
    }

    static class DriveMachine {
        private char[][] runs;
        private int[] carPositions;

        DriveMachine(final String road, final int n) {
            runs = new char[n + 1][road.length()];
            carPositions = new int[runs[0].length];

            for (int i = 0; i < road.length(); i++) {
                if (road.charAt(i) == CAR) {
                    carPositions[i] = i;
                } else {
                    carPositions[i] = -1;
                }
            }
            //carPositions[carPositions.length - 1] = -1;
            runs[0] = road.toCharArray();
        }

        public String[] run() {
            buildRunsWithTrafficLight();

            for (int i = 1; i < runs.length; i++) {
                for (int j = carPositions.length - 1; j > -1; j--) {

                    if (carPositions[j] > -1) {
                        char nextRoadPart = (j == runs[i].length - 1) ? '.' : runs[i][j + 1];
                        char currentRoadPart = runs[i][j];

                        if ((nextRoadPart == RED) || (nextRoadPart == ORANGE) || (nextRoadPart == CAR)) {
                            keepCarOnRoadPart(i, j);

                        } else if (nextRoadPart == GREEN && j+1 == runs[i].length-1) {
                            moveCarToNextRoadpart(i, j);

                        } else if (nextRoadPart == GREEN && (carPositions[j + 2] == -1)) {
                            moveCarToNextRoadpart(i, j);

                        } else if (nextRoadPart == GREEN && (carPositions[j + 2] > -1)) {
                            keepCarOnRoadPart(i, j);

                        } else if (currentRoadPart == GREEN && (carPositions[j] == -1)) {
                            moveCarToNextRoadpart(i, j);

                        } else if (j == runs[i].length - 1) {
                            moveCarOutOfRoad(i, j);

                        } else {
                            moveCarToNextRoadpart(i, j);
                        }
                    }
                }
                carPositions[carPositions.length - 1] = -1;

                System.out.format("%03d %s\n", i, String.valueOf(runs[i]));
            }

            String[] result = new String[runs.length];
            for (int i = 0;i < runs.length; i++) {
                result[i] = String.valueOf(runs[i]);
            }

            return result;
        }

        private void moveCarOutOfRoad(final int i, final int j) {
            runs[i][j] = '.';
            carPositions[j] = -1;
        }

        private void keepCarOnRoadPart(final int i, final int j) {
            runs[i][j] = CAR;
        }

        private void moveCarToNextRoadpart(final int i, final int j) {

            runs[i][j + 1] = CAR;
            carPositions[j + 1] = carPositions[j];
            carPositions[j] = -1;
        }

        private void buildRunsWithTrafficLight() {
            for (int i = 1; i < runs.length; i++) {
                for (int j = 0; j < runs[i].length; j++) {
                    final RoadPartState previousRoadState = RoadPartState.valueOfKey(runs[i - 1][j]);
                    final RoadPartState roadPartState = previousRoadState.computePosition(runs, i, j);
                    runs[i][j] = roadPartState.key;
                }
            }
        }
    }

    enum RoadPartState {
        GREEN('G', 5) {
            @Override
            protected RoadPartState change(final int unitCount) {
                return (unitCount == timeUnitNumber) ? ORANGE : GREEN;
            }
        },
        ORANGE('O', 1) {
            @Override
            protected RoadPartState change(final int unitCount) {
                return (unitCount == timeUnitNumber) ? RED : ORANGE;
            }
        },
        RED('R', 5) {
            @Override
            protected RoadPartState change(final int unitCount) {
                return (unitCount == timeUnitNumber) ? GREEN : RED;
            }
        },
        ROAD('.', 1) {
            @Override
            protected RoadPartState change(final int timeUnit) {
                return ROAD;
            }
        };

        char key;
        int timeUnitNumber;

        RoadPartState(final char key, final int timeUnitNumber) {
            this.timeUnitNumber = timeUnitNumber;
            this.key = key;
        }

        static RoadPartState valueOfKey(char key) {
            for (RoadPartState v : RoadPartState.values()) {
                if (v.key == key) {
                    return v;
                }
            }
            return ROAD;
        }

        RoadPartState computePosition(char[][] runs, final int i, final int j) {
            int lightCount = 0;
            for (int k = i - 1; k >= 0 && k >= i - timeUnitNumber; k--) {
                if (runs[k][j] == key) {
                    lightCount++;
                } else if (runs[k][j] == CAR) {
                    lightCount++;
                }
            }
            return change(lightCount);
        }

        abstract RoadPartState change(int timeUnit);

        @Override
        public String toString() {
            return Character.toString(this.key);
        }
    }

}