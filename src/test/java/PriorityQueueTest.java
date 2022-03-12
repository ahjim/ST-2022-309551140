import java.util.PriorityQueue;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;


public class PriorityQueueTest {
    static Stream<Arguments> argumentsStream() {
        return Stream.of(
                //Arguments.of(new int[]{5,4,3,2,1}, new int[]{1,2,3,4,5}),
                Arguments.of(new int[]{5,4,3,2,1}, new int[]{2,3,4,5,6}),
                Arguments.of(new int[]{1,4,3,2,5}, new int[]{1,2,3,4,6}),
                Arguments.of(new int[]{-2,4,-5,3,-1}, new int[]{-5,-2,-1,3,3}),
                Arguments.of(new int[]{24,-9,0,97,-55}, new int[]{-55,-9,0,23,97}),
                Arguments.of(new int[]{15,32,7,69,58}, new int[]{7,15,32,58,68})
        );
    }

    @ParameterizedTest(name="#{index} - Test with Argument={0},{1}")
    @MethodSource("argumentsStream")
    public void PriorityQueue_RunTest(int[] random_array,int[] correct_array) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        int[] result = new int[random_array.length];
        for (int i = 0;i<random_array.length;i++){
            queue.add(random_array[i]);
        }

        for (int i = 0;i<random_array.length;i++){
            result[i]= queue.poll();
        }
        assertArrayEquals(result,correct_array);
    }

    @Test
    public void WhenExceptionThrown_initialCapacityLessThan1() {
        //Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            PriorityQueue queue=new PriorityQueue(0);
        });
    }

    @Test
    public void WhenExceptionThrown_AddNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            PriorityQueue queue=new PriorityQueue();
            queue.add(null);
        });
    }

    @Test
    public void WhenExceptionThrown_OfferNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            PriorityQueue queue=new PriorityQueue();
            queue.offer(null);
        });
    }
}