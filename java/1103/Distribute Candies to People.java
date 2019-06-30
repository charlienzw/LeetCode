/*
    Distribute the candies with 1, 2, ..., n, n + 1, n + 2,...
        How many rounds will be till all the candies are distributed?
            How many candies after i rounds?
                i = 1
                    (1 + n) * n / 2
                i = 2
                    (1 + n) * n / 2 + n ^ 2 + (1 + n) * n / 2
                i = 3
                    (1 + n) * n / 2 + n ^ 2 + (1 + n) * n / 2 + 2 * n ^ 2 + (1 + n) * n / 2
                i
                    i * (1 + n) * n / 2 + (1 + i - 1) * (i - 1) / 2 * n ^ 2 = i(1 + n)n/2 + n ^ 2 * i(i - 1)/2
            
        After i rounds, how many do j-th person have?
            i = 1
                1, 2, ..., n
            i = 2
                1 + n + 1, 2 + n + 2, ..., n + n + n
            i = 3
                1 + n + 1 + 2n + 1, 2 + n + 2 + 2n + 2, n + n + n + 2n + n
            i
                i + (1 + i - 1)(i - 1) / 2 * n, 2i + (1 + i - 1)(i - 1) / 2 * n, ni + (1 + i - 1)(i - 1) / 2 * n 
            i
                j (from 0)
                    i(j + 1) + i(i - 1)/2 * n
    
*/
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        // How many rounds will be till all the candies are distributed?
        int sum = 0, i = 1;
        int validSum = 0;
        while (sum <= candies) {
            validSum = sum;
            sum = i * (1 + num_people) * num_people / 2 + num_people * num_people * i * (i - 1) / 2;
            i++;
        }
        i--;
        
        // After i - 1 rounds, how many do j-th person have?
        int[] res = new int[num_people];
        for(int j = 0; j < num_people; j++) {
            res[j] = (i - 1) * (j + 1) + (i - 1) * (i - 2) / 2 * num_people;
        }
        
        // Add the i rounds
        for (int j = 0; j < num_people; j++) {
            int jCandies = num_people * (i - 1) + j + 1;
            if (validSum + jCandies > candies) {
                res[j] += candies - validSum;
                break;
            }
            res[j] += jCandies;
            validSum += jCandies;
        }
        return res;
    }
}