class MyArrayList <T> {

    	private T[] innerArray;
        private int size;
        
        public MyArrayList()  {
            innerArray = new T[10];
            size = 0;
        }
        private void increaseSize() {
            T[] tmpArray = new T[innerArray.Count() + 10];
            for (int i = 0; i < innerArray.Count(); i++) {
                tmpArray[i] = innerArray[i];
            }
            innerArray = tmpArray;
        }

        public void add(int position, T newElement) {
            if (size >= innerArray.Count()) {
                increaseSize();
            }
            for (int i = size; i > position; i--) {
                innerArray[i] = innerArray[i - 1];
            }
            innerArray[position] = newElement;
            size++;
        }

        public void add(T newElement) {
            add(size, newElement);
        }

        public void set(int position, T newElement) {
            innerArray[position] = newElement;
        }

        public int getSize() {
            return size;
        }

        public void remove(int position) {
            for (int i = position; i < size; i++) {
                innerArray[i] = innerArray[i + 1];
            }
            size--;
            innerArray[size] = default(T);
        }

        public T get(int position) {
            return innerArray[position];
        }


}
