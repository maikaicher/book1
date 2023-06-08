package Kap13.Java.Listing55_59;

public class MyArrayList {
    	private Object[] innerArray;
        private int size;
        
        public MyArrayList() {
            innerArray = new Object[10];
            size = 0;
        }

        private void increaseSize() {
            Object[] tmpArray = new Object[innerArray.length + 10];
            for (int i = 0; i < innerArray.length; i++) {
                tmpArray[i] = innerArray[i];
            }
            innerArray = tmpArray;
        }

        public void add(int position, Object newElement) {
            if (size >= innerArray.length) {
                increaseSize();
            }
            for (int i = size; i > position; i--) {
                innerArray[i] = innerArray[i - 1];
            }
            innerArray[position] = newElement;
            size++;
        }

        public void add(Object newElement) {
            add(size, newElement);
        }

        public void set(int position, Object newElement) {
            innerArray[position] = newElement;
        }

        public int size() {
            return size;
        }

        public void remove(int position) {
            for (int i = position; i < size; i++) {
                innerArray[i] = innerArray[i + 1];
            }
            size--;
            innerArray[size] = null;
        }

        public Object get(int position) {
            return innerArray[position];
        }


}
