class Solution {
    public String frequencySort(String s) {
        int arr[][] = new int[123][2];

        for(char c: s.toCharArray()){
            arr[c][0]++;
            arr[c][1]=c;
        }

        Arrays.sort(arr, (a,b)-> b[0]-a[0]);
        StringBuilder str = new StringBuilder("");
        for(int i=0;i<123;i++){
            int freq = arr[i][0];
            if(freq==0){
                break;
            }
            for(int j=0;j<freq;j++){
                str.append((char)arr[i][1]);
            }
        }
        return str.toString();
    }
}