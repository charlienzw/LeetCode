class Solution {
    public int dayOfYear(String date) {
        String[] dateArr = date.split("-");
        int year = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int day = Integer.parseInt(dateArr[2]);
        int[] monthMap;
        if (isLeap(year)) {
            monthMap = new int[] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        } else {
            monthMap = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        }
        int res = 0;
        for (int i = 0; i < month - 1; i++) {
            res += monthMap[i];
        }
        res += day;
        return res;
    }
    
    public boolean isLeap(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0 && year % 400 != 0) return false;
            return true;
        }
        return false;
    }
}