class Solution {
    public void sortColors(int[] nums) {
        int startred=-1,startwhite=-1,startblue=-1,color,tmp,nowi;
        for(int i=0;i<nums.length;i++)
        {
            color=nums[i];
            switch(color)
            {
                case 0:
                    if (startred==-1)
                    {
                        startred=i;
                        if (startred>startblue&&startblue!=-1)
                        {
                            tmp=nums[startblue];
                            nums[startblue]=nums[startred];
                            nums[startred]=tmp;
                            startred=startblue;
                            startblue=startblue+1;
                        }
                        if (startred>startwhite&&startwhite!=-1)
                        {
                            tmp=nums[startwhite];
                            nums[startwhite]=nums[startred];
                            nums[startred]=tmp;
                            startred=startwhite;
                            startwhite=startwhite+1;
                        }
                    }
                    else
                    {
                        nowi=i;
                        if (nowi>startblue&&startblue!=-1)
                        {
                            tmp=nums[startblue];
                            nums[startblue]=nums[nowi];
                            nums[nowi]=tmp;
                            nowi=startblue;
                            startblue=startblue+1;
                        }
                        if (nowi>startwhite&&startwhite!=-1)
                        {
                            tmp=nums[startwhite];
                            nums[startwhite]=nums[nowi];
                            nums[nowi]=tmp;
                            nowi=startwhite;
                            startwhite=startwhite+1;
                        }                        
                    }
                    break;
                case 1:
                    if (startwhite==-1)
                    {
                        startwhite=i;
                        if (startwhite>startblue&&startblue!=-1)
                        {
                            tmp=nums[startblue];
                            nums[startblue]=nums[startwhite];
                            nums[startwhite]=tmp;
                            startwhite=startblue;
                            startblue=startblue+1;
                        }
                    }
                    else
                    {
                        nowi=i;
                        if (nowi>startblue&&startblue!=-1)
                        {
                            tmp=nums[startblue];
                            nums[startblue]=nums[nowi];
                            nums[nowi]=tmp;
                            nowi=startblue;
                            startblue=startblue+1;
                        }                     
                    }
                    break;
                case 2:
                    if(startblue==-1)
                    {
                        startblue=i;
                    }
                    break;
            }
        }

    }
}