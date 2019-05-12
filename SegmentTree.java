import java.sql.SQLOutput;

public class SegmentTree {

    static int min(int a, int b) {
        if(a<b)
            return a;
        else
            return b;
    }

    public static void constructSegmentTree(int[] segmentTree, int[] input, int low, int high, int pos) {
        if(low == high) {
            segmentTree[pos] = input[low];
            return;
        }

        int mid = (low+high) / 2;
        constructSegmentTree(segmentTree, input, low, mid, 2*pos + 1);
        constructSegmentTree(segmentTree, input, mid+1, high, 2*pos + 2);
        segmentTree[pos] = min(segmentTree[2*pos+1], segmentTree[2*pos+2]);
    }

    public static int rangeMinQuery(int[] segmentTree, int low, int high, int qlow, int qhigh, int pos) {
        //If the range completely overlaps
        if(high <= qhigh && low >= qlow) {
            return segmentTree[pos];
        }

        //If the range query doesn't overlap
        if(high < qlow || low > qhigh) {
            return Integer.MAX_VALUE;
        }

        int mid = (low+high)/2; //Important to put paranthesis
        return min(rangeMinQuery(segmentTree, low, mid, qlow, qhigh, 2*pos+1),
            rangeMinQuery(segmentTree, mid+1, high, qlow, qhigh, 2*pos+2));
    }

    public static int findMin(int[] segmentTree, int len, int qlow, int qhigh) {
        return rangeMinQuery(segmentTree, 0, len-1, qlow, qhigh, 0);
    }

    public static void main(String[] args) {
        int input[] = {0,3,4,2,1,6,-1};
        int len = input.length;

        int num = len;
        int pow = 1;

        while(num != 0) {
            num = num/2;
            pow*=2;
        }

        int[] segmentTree = new int[2*pow-1];
        for(int i=0; i< segmentTree.length; i++) {
            segmentTree[i] = Integer.MAX_VALUE;
        }
        constructSegmentTree(segmentTree, input, 0, input.length-1, 0);

        assert 0 == findMin(segmentTree, input.length, 0, 3);
        assert -1 == findMin(segmentTree, input.length, 5, 6);

        System.out.println(findMin(segmentTree, input.length, 0, 3));
        System.out.println(findMin(segmentTree, input.length,5, 6));
    }
}
