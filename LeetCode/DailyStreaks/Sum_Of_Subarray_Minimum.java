class Solution {
    public int[] getNSL(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return result;
    }

    public int[] getNSR(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return result;
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length, M = 1000000007;
        long sum = 0;
        int[] NSL = getNSL(arr, n);
        int[] NSR = getNSR(arr, n);

        for(int i=0; i<n; i++) {
            long d1 = i-NSL[i];
            long d2 = NSR[i] - i;

            long totalWays = d1 * d2;
            long sumInTotalWays = arr[i] * totalWays;
            sum = (sum + sumInTotalWays) % M;
        }
        return (int) sum;
    }
}