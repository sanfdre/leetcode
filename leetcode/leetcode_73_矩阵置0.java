package leetcode;

public class leetcode_73_矩阵置0 {

    public static void main(String[] args) {
        leetcode_73_矩阵置0 leetcode = new leetcode_73_矩阵置0();
        int[][] ma = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        leetcode.setZeroes(ma);
        System.out.println(ma);
    }

    /**
     * 解法：
     * 1：空间复杂度m*n  新建一个m*n的矩阵作为标记
     * 2：空间复杂度为m+n 新建两个分别为m和n的数组  遍历一遍原矩阵 m数组记录哪些行有0 n数组哪些列有0
     * 3：空间复杂度为常数 用原数组的第一行第一列作为方法二中的m n数组即可
     * 下面解法是解法3
     */
        public void setZeroes(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;

            if(m==1 || n==1){
                oneRowOrOneColumn(matrix,m,n);
            }

            boolean row = false;
            boolean column = false;
            for (int i = 0;i<m;i++){
                if(matrix[i][0]==0) {
                    row = true;
                    break;
                }
            }

            for (int i = 0;i<n;i++){
                if(matrix[0][i]==0){
                    column = true;
                    break;
                }
            }

            for(int i = 1;i<m;i++){
                for (int j = 1;j<n;j++){
                    if(matrix[i][j]==0){
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }

            for (int i = 1;i<m;i++){
                if(matrix[i][0]==0){
                    for (int j = 0;j<n;j++){
                        matrix[i][j] = 0;
                    }
                }
            }

            for (int i = 1;i<n;i++){
                if(matrix[0][i]==0){
                    for (int j = 0;j<m;j++){
                        matrix[j][i] = 0;
                    }
                }
            }

            if(row){
                for (int i = 0;i<m;i++){
                    matrix[i][0] = 0;
                }
            }
            if(column){
                for (int i = 0;i<n;i++){
                    matrix[0][i] = 0;
                }
            }

        }

        /**
         * 单行或者单列的单独处理
         * @param matrix
         * @param m
         * @param n
         */
        public void oneRowOrOneColumn(int[][] matrix,int m,int n){
            boolean hasZero = false;
            for (int i=0;i<m;i++){
                for (int j=0;j<n;j++){
                    if(matrix[i][j]==0){
                        hasZero = true;
                    }
                }
            }
            if(hasZero){
                for (int i=0;i<m;i++){
                    for (int j=0;j<n;j++){
                        matrix[i][j]=0;
                    }
                }
            }
        }
}
