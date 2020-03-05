package 常用算法;

public class 二分查找 {

    /**
     * 非递归实现二分查找
     * @param arr
     * @param key
     * @return
     */
    public static int commonBinarySearch(int[] arr, int key){
        int low = 0;
        int high = arr.length - 1;
        int middle = 0;

        //特殊情况处理
        if(key < arr[low] || key > arr[high] || low > high){
            return -1;
        }

        while(low<=high){
            middle = (low+high)>>1;
            if(key > arr[middle]){
                low = middle+1;
            }else if(key < arr[middle]){
                high = middle-1;
            }else{
                return middle;
            }
        }

        return -1;
    }

    /**
     * 递归实现二分查找
     * @param arr
     * @param key
     * @param low
     * @param high
     * @return
     */
    public static int binarySearch(int[] arr, int key, int low, int high){
        if(key < arr[low] || key > arr[high] || low > high) return -1;

        int middle = (low+high)>>1;
        if(key < arr[middle]){
            return binarySearch(arr, key, low, middle-1);
        }else if(key > arr[middle]){
            return binarySearch(arr, key, middle+1, high);
        }else{
            return middle;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,22,33,44,55,66,77,88};
        int index = binarySearch(arr, 22, 0, arr.length-1);
        System.out.println(index);
    }

}
