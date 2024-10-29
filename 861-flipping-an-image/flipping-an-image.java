class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        // for(int rows =0; rows < image.length; rows++){
        //     for(int cols = 0; cols< image[rows].length; cols++){
        //         //invert array
        //         //xor while inverting 
        //         int start = 0;
        //         int end = image.length-1; //since n*n array
        //         while(start<end){
        //             int temp = image[rows][start];
        //             image[rows][start] = image[cols][end];
        //             image[rows][start] ^=  1;
        //             image[cols][end] = temp;
        //             image[cols][end] ^=  1;
        //             start++;
        //             end--;
        //         }
                
        //         image[rows][start]  ^= 1;
            
        //     }
            
        // }
        for(int[] row: image){
            //invert the array
            for(int i=0; i< (image[0].length+1)/2; i++){
                int temp = row[i] ^1; // xor 1
                row[i]= row[image[0].length -i -1]^1;
                row[image[0].length -i -1]=temp;


            }
        }
        return image;
    }
}