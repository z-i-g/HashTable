public class HashTable {
    public int size;
    public int step;
    public String [] slots;

    public HashTable(int sz, int stp)
    {
        size = sz;
        step = stp;
        slots = new String[size];
        for(int i=0; i<size; i++) slots[i] = null;
    }

    public int hashFun(String value)
    {
        int intVal = 0;
        for (byte b: value.getBytes()) {
            intVal = intVal + b;
        }
        return Math.abs(intVal % size);
        // всегда возвращает корректный индекс слота
    }

    public int seekSlot(String value)
    {
        int slotIndex = hashFun(value);
        if (slots[slotIndex] == null)
            return slotIndex;

        for (int i = 0; i < size; i++) {
            if (slotIndex + step >= size) {
                slotIndex = size - (slotIndex + step);
                slotIndex = Math.abs(slotIndex);
            } else {
                slotIndex = slotIndex + step;
            }
            if (slots[slotIndex] == null)
                return slotIndex;
        }
        return -1;
    }

    public int put(String value)
    {
        int slotIndex = seekSlot(value);
        if (seekSlot(value) != -1) {
            slots[slotIndex] = value;
            return slotIndex;
        }
        return -1;
    }

    public int find(String value)
    {
        for (int i = 0; i < size; i++) {
            if (value.equals(slots[i]))
                return i;
        }
        return -1;
    }
}
