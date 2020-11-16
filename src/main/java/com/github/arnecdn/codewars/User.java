package com.github.arnecdn.codewars;

import java.util.Arrays;
import java.util.List;

public class User {

    public static final int RANK_UP_PROGRESS_LIMIT = 100;
    static final List<Integer> LEGAL_RANKS = Arrays.asList(-8, -7, -6, -5, -4, -3, -2, -1, 1, 2, 3, 4, 5, 6, 7, 8);

    public int rank;
    public int progress;

    public User(final int rank) {
        this.rank = rank;
        progress = 0;
    }

    public User() {
        this.rank = -8;
        progress = 0;
    }

    public void incProgress(int activityRank) {
        if (isRankLegal(activityRank)) {
            throw new IllegalArgumentException("Invalid rank " + activityRank);
        }

        int computedProgress = calculateTotalProgress(rank, this.progress, activityRank);
        ComputedUserRank computedUserRank = progressRanks(this.rank, computedProgress);

        this.rank = computedUserRank.computedRank;
        this.progress = computedUserRank.computedProgress;
    }

    private static boolean isRankLegal(int rank) {
        return !LEGAL_RANKS.contains(rank);
    }

    private static int calculateTotalProgress(int currentUserRank, int currentUserProgress, int activityRank ) {
        int rankDiff = LEGAL_RANKS.indexOf(activityRank) - LEGAL_RANKS.indexOf(currentUserRank);

        if (rankDiff > 0) {
            return currentUserProgress + 10 * (rankDiff) * (rankDiff);
        } else if (rankDiff == 0) {
            return currentUserProgress + 3;
        } else if (rankDiff == -1) {
            return currentUserProgress + 1;
        }

        return currentUserProgress;
    }


    private static ComputedUserRank progressRanks(final int rank, int inrementedProgress) {
        if (isUserTopRanked(rank)) {
            return new ComputedUserRank(rank, 0);
        }

        if (inrementedProgress < RANK_UP_PROGRESS_LIMIT) {
            return new ComputedUserRank(rank, inrementedProgress);
        }

        return progressRanks(nextRank(rank), inrementedProgress - RANK_UP_PROGRESS_LIMIT);
    }

    private static boolean isUserTopRanked(int userRank) {
        return LEGAL_RANKS.get(LEGAL_RANKS.size() - 1) == userRank;
    }

    private static int nextRank(final int userRank) {
        return LEGAL_RANKS.get(LEGAL_RANKS.indexOf(userRank) + 1);
    }

    static class ComputedUserRank{
        int computedRank;
        int computedProgress;

        public ComputedUserRank(final int computedRank, final int computedProgress) {
            this.computedRank = computedRank;
            this.computedProgress = computedProgress;
        }
    }
}
