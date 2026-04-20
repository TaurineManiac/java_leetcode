public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        for(int i = 0; i < gas.length; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalGas < totalCost){
            return -1;
        }
        int step = 0;
        int start=0;
        for(int i = 0; i < gas.length; i++){
            step+=gas[i]-cost[i];
            if(step<0){
                start = i+1;
                step = 0;
            }
        }
        return start;
    }
//        int indexOfMax = 0;
//        for(int i = 0; i < gas.length; i++){
//            if(gas[i] - cost[i] > gas[indexOfMax]-cost[indexOfMax]){
//                indexOfMax = i;
//            }
//        }
//        int step=0;
//        step+=gas[indexOfMax];
//        for(int i = indexOfMax+1; i < gas.length; i++){
//            if(step<cost[i-1]){
//                return -1;
//            }
//            step=step+gas[i]-cost[i-1];
//        }
//        step=step+gas[0]-cost[gas.length-1];
//        for(int i = 1; i <= indexOfMax; i++){
//            if(step<cost[i-1]){
//                return -1;
//            }
//            step=step+gas[i]-cost[i-1];
//        }
//
//
//        return indexOfMax;
//    }
}

class MainOfGasStation {
    public static void main(String[] args) {
        GasStation s = new GasStation();
        int[] gas = {5,8,2,8};
        int[] cost = {6,5,6,6};
        System.out.println(s.canCompleteCircuit(gas, cost));
    }
}
