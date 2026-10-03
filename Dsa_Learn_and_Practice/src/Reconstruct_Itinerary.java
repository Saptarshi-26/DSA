import java.util.*;
import java.util.stream.IntStream;

public class Reconstruct_Itinerary {
    public List<String> findItinerary(String ticket,
                                      Map<String, List<String>> branches,
                                      Map<String, Stack<List<String>>> record,
                                      Map<String, Integer> branchIterationNo) {

        //System.out.println(ticket);

        if (!branches.containsKey(ticket) ||
                branchIterationNo.get(ticket) >= branches.get(ticket).size()) {
            return new ArrayList<>(List.of(ticket));
        }

        int i = branchIterationNo.get(ticket);

        if (i == 0) Collections.sort(branches.get(ticket));

        for (; i < branches.get(ticket).size(); i++) {
            if (i < branchIterationNo.get(ticket)) continue;
            String nextTicket = branches.get(ticket).get(i);
            branchIterationNo.put(ticket, i + 1);
            List<String> itinerary = findItinerary(nextTicket, branches, record, branchIterationNo);
            itinerary.addFirst(ticket);
            record.get(ticket).push(itinerary);
        }
        List<String> result = new ArrayList<>();

        Stack<List<String>> stack = record.get(ticket);
        while (!stack.isEmpty()) {
            List<String> itinerary = stack.pop();
            List<String> sublistItinerary = itinerary;
            if (!result.isEmpty() && itinerary.getFirst().equals(result.getLast())) {
                sublistItinerary = IntStream.range(1, itinerary.size()).
                        mapToObj(itinerary::get).toList();
            }
            result.addAll(sublistItinerary);
        }


        return result;


    }

    public List<String> findItinerary(List<List<String>> tickets) {

        HashMap<String, List<String>> branches = new HashMap<>();
        HashMap<String, Integer> branchIterationNo = new HashMap<>();
        HashMap<String, Stack<List<String>>> record = new HashMap<>();
        for (List<String> ticket : tickets) {
            if (!branches.containsKey(ticket.getFirst())) {
                record.put(ticket.getFirst(), new Stack<>());
                branches.put(ticket.getFirst(), new ArrayList<>(List.of(ticket.get(1))));
                branchIterationNo.put(ticket.getFirst(), 0);
            } else {
                branches.get(ticket.getFirst()).add(ticket.get(1));
            }
        }
        return findItinerary("JFK", branches, record, branchIterationNo);
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of tickets ");
        int size = sc.nextInt();
        System.out.println("enter the tickets ");
        List<List<String>> tickets = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<String> ticket = new ArrayList<>();
            ticket.add(sc.next());
            ticket.add(sc.next());
            tickets.add(ticket);
        }
        System.out.println(new Reconstruct_Itinerary().findItinerary(tickets));
    }
}
