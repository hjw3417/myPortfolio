function calculateRank(score) {
    if (score >= 0 && score <= 500) {
        return "bronze";
    } else if (score >= 501 && score <= 1000) {
        return "silver";
    } else if (score >= 1001 && score <= 1500) {
        return "gold";
    } else if (score >= 1501 && score <= 2000) {
        return "platinum";
    } else {
        return "unknown";
    }