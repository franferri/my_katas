package coup.network;

public class StdIn {

    public static void main(String[] args) throws InterruptedException {

        String fromThread = "";

        StdInThreat threat = new StdInThreat();
        threat.start();

        while (true) {

            if (!fromThread.equals(threat.fromThread())) {
                System.out.println(threat.fromThread());
            }

            fromThread = threat.fromThread();
            
        }

    }

}
