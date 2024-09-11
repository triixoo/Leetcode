package Easytasks;
import  java.util.List;

public class Cards {
    class Bubble {
        private long[] a;
        private int elements;

        public Bubble(int max) {
            a = new long[max];
            elements = 0;
        }

        public void into(long value) {
            a[elements] = value;
            elements++;

        }

        public void printer() {
            for (int i = 0; i < elements; i++) {
                System.out.println(a[i]);
            }
        }

        private void swap(int first, int second) {
            long dummy = a[first];
            a[first] = a[second];
            a[second] = dummy;
        }

        public void bubbleSorter() {
            for (int out = elements - 1; out >= 1; out--) {
                for (int in = 0; in < out; in++) {
                    if (a[in] > a[in + 1])
                        swap(in, in + 1);
                }
            }
        }
    }
}

