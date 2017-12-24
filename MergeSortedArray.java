
public class MergeSortedArray {

    public static void main(String args[])throws Exception{

        int[] a1 = new int[]{ 1 };
        int[] a2 = new int[]{ 0};

        MergeSortedArray merge = new MergeSortedArray();
        merge.merge (a1,1,a2,0);

    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int finalArray[] = new int[m+n];
        int i = m+n-1;

        for(; i>=0; i--){

            if(m==0){
                for(int x = n-1; x>=0 ; x-- , i-- ){
                    finalArray[i] = nums2[x];
                }
                break;
            }else if(n==0){
                for(int x = m-1; x>=0 ; x-- , i--){
                    finalArray[i] = nums1[x];
                }
                break;
            }
            System.out.println("m= " + m + "nums1[m]" + nums1[m-1]+ "n= " + n + "nums2[n]" + nums2[n-1]);
            if(nums1[m-1]<nums2[n-1]){
                finalArray[i] = nums2[n-1];
                n--;
            }else
            if(nums1[m-1]>nums2[n-1]){
                finalArray[i] = nums1[m-1];
                m--;
            }else
            if(nums1[m-1] == nums2[n-1]){
                finalArray[i] = nums2[n-1];
                finalArray[i-1] = nums2[n-1];
                i--;m--;n--;

            }

        }

        for (i= 0; i < nums1.length ; i++){
            nums1[i] = finalArray[i];
            System.out.println(nums1[i]);
        }
    }
}
