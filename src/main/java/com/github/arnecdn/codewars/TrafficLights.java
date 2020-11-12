package com.github.arnecdn.codewars;

public class TrafficLights {
    public static final char CAR = 'C';

    public static String[] trafficLights(String road, int n) {
        DriveMachine driveMachine = new DriveMachine(road, n);
        return driveMachine.run();
    }

    static class DriveMachine {
        private int carPosition = 0;
        private char[][] runs;
        private RoadPartState roadPartState;

        DriveMachine(final String road, final int n) {
            runs = new char[n + 1][road.length()];
            runs[0] = road.toCharArray();
            carPosition = road.indexOf(CAR);
        }

        public String[] run() {
            for (int i = 1; i < runs.length; i++) {
                for (int j = 0; j < runs[i].length; j++) {
                    final RoadPartState previousRoadState = RoadPartState.valueOfKey(runs[i - 1][j]);
                    final RoadPartState roadPartState = previousRoadState.computePosition(runs, i, j);
                    runs[i][j] = roadPartState.key;
                }
            }

            for (int i = 0; i < runs.length; i++) {
                for (int j = 0; j < runs[i].length; j++) {
                    roadPartState = RoadPartState.valueOfKey(runs[i][j]);

                    if (carPosition == j) {
                        if ((roadPartState.equals(RoadPartState.RED) || roadPartState.equals(RoadPartState.ORANGE))) {
                            runs[i][carPosition - 1] = CAR;
                        } else {
                            runs[i][j] = CAR;
                            carPosition++;
                        }
                        break;
                    }
                }
            }

            String[] result = new String[runs.length];
            for(int i = 0; i < runs.length; i++){
                result[i] = String.valueOf(runs[i]);
            }

            return result;
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
