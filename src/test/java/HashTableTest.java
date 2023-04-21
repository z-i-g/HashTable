import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    HashTable hashTable = new HashTable(17, 3);

    @Test
    public void hashFunTest() {
        for (int i = 0; i < 1000; i++) {
            assertTrue(hashTable.hashFun("val" + i) >= 0);
            assertTrue(hashTable.hashFun("val" + i) < hashTable.size);
        }
    }

    @Test
    public void seekSlot_whenEmpty() {
        int slotIndex = hashTable.seekSlot("1");
        assertTrue(slotIndex >= 0 && slotIndex < hashTable.size);
    }

    @Test
    public void seekSlot_whenHalfFull() {
        hashTable.put("1");
        hashTable.put("2");
        hashTable.put("3");
        hashTable.put("4");
        hashTable.put("5");
        hashTable.put("6");
        hashTable.put("7");
        hashTable.put("8");
        hashTable.put("9");

        int slotIndex = hashTable.seekSlot("10");

        assertNull(hashTable.slots[slotIndex]);
    }

    @Test
    public void seekSlot_whenOneSlotIsAvailable() {
        hashTable.put("1");
        hashTable.put("2");
        hashTable.put("3");
        hashTable.put("4");
        hashTable.put("5");
        hashTable.put("6");
        hashTable.put("7");
        hashTable.put("8");
        hashTable.put("9");
        hashTable.put("10");
        hashTable.put("11");
        hashTable.put("12");
        hashTable.put("13");
        hashTable.put("14");
        hashTable.put("15");
        hashTable.put("16");

        int slotIndex = hashTable.seekSlot("10");

        assertNull(hashTable.slots[slotIndex]);
    }

    @Test
    public void seekSlot_whenFillAllSlots() {
        hashTable.put("1");
        hashTable.put("2");
        hashTable.put("3");
        hashTable.put("4");
        hashTable.put("5");
        hashTable.put("6");
        hashTable.put("7");
        hashTable.put("8");
        hashTable.put("9");
        hashTable.put("10");
        hashTable.put("11");
        hashTable.put("12");
        hashTable.put("13");
        hashTable.put("14");
        hashTable.put("15");
        hashTable.put("16");
        hashTable.put("17");

        int slotIndex = hashTable.seekSlot("10");

        assertEquals(-1, slotIndex);
    }

    @Test
    public void put_whenEmpty() {
        int slotIndex = hashTable.put("1");

        assertNotEquals(-1, slotIndex);
    }

    @Test
    public void put_whenHalfFull() {
        assertNotEquals(-1, hashTable.put("1"));
        assertNotEquals(-1, hashTable.put("2"));
        assertNotEquals(-1, hashTable.put("3"));
        assertNotEquals(-1, hashTable.put("4"));
        assertNotEquals(-1, hashTable.put("5"));
        assertNotEquals(-1, hashTable.put("6"));
        assertNotEquals(-1, hashTable.put("7"));
        assertNotEquals(-1, hashTable.put("8"));
        assertNotEquals(-1, hashTable.put("9"));
    }

    @Test
    public void put_whenOneSlotIsAvailable() {
        assertNotEquals(-1, hashTable.put("1"));
        assertNotEquals(-1, hashTable.put("2"));
        assertNotEquals(-1, hashTable.put("3"));
        assertNotEquals(-1, hashTable.put("4"));
        assertNotEquals(-1, hashTable.put("5"));
        assertNotEquals(-1, hashTable.put("6"));
        assertNotEquals(-1, hashTable.put("7"));
        assertNotEquals(-1, hashTable.put("8"));
        assertNotEquals(-1, hashTable.put("9"));
        assertNotEquals(-1, hashTable.put("10"));
        assertNotEquals(-1, hashTable.put("11"));
        assertNotEquals(-1, hashTable.put("12"));
        assertNotEquals(-1, hashTable.put("13"));
        assertNotEquals(-1, hashTable.put("14"));
        assertNotEquals(-1, hashTable.put("15"));
        assertNotEquals(-1, hashTable.put("16"));
    }

    @Test
    public void put_whenFillAllSlots() {
        assertNotEquals(-1, hashTable.put("1"));
        assertNotEquals(-1, hashTable.put("2"));
        assertNotEquals(-1, hashTable.put("3"));
        assertNotEquals(-1, hashTable.put("4"));
        assertNotEquals(-1, hashTable.put("5"));
        assertNotEquals(-1, hashTable.put("6"));
        assertNotEquals(-1, hashTable.put("7"));
        assertNotEquals(-1, hashTable.put("8"));
        assertNotEquals(-1, hashTable.put("9"));
        assertNotEquals(-1, hashTable.put("10"));
        assertNotEquals(-1, hashTable.put("11"));
        assertNotEquals(-1, hashTable.put("12"));
        assertNotEquals(-1, hashTable.put("13"));
        assertNotEquals(-1, hashTable.put("14"));
        assertNotEquals(-1, hashTable.put("15"));
        assertNotEquals(-1, hashTable.put("16"));
        assertNotEquals(-1, hashTable.put("17"));


        assertEquals(-1, hashTable.put("18"));
        assertEquals(-1, hashTable.put("18"));
        assertEquals(-1, hashTable.put("18"));
        assertEquals(-1, hashTable.put("18"));
        assertEquals(-1, hashTable.put("18"));
        assertEquals(-1, hashTable.put("18"));
        assertEquals(-1, hashTable.put("18"));
        assertEquals(-1, hashTable.put("18"));
    }

    @Test
    public void find_whenEmpty() {
        assertEquals(-1, hashTable.find("1"));
    }

    @Test
    public void find_whenNotEmpty() {
        int putIndex = hashTable.put("1");

        assertEquals(putIndex, hashTable.find("1"));
    }

    @Test
    public void find_whenNotContainsValue() {
        int putIndex = hashTable.put("1");

        assertEquals(-1, hashTable.find("2"));
    }

}