package se.hig.aod.lab0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest {

	private LinkedList<Integer> listUnderTest;
	private final int[] fixture = { 1, 2, 3, 4, 5 };

	/**
	 * Resets list to a new empty LinkedList-instance
	 * before each test method is executed.
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		listUnderTest = new LinkedList<Integer>();
	}

	/**
	 * Sets list to null after each test method is executed.
	 * 
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		listUnderTest = null;
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#isEmpty()}.
	 */
	@Test
	public void testEmptyListIsEmpty() {
		assertTrue(listUnderTest.isEmpty(), "An empty list instance should not contain any item");
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#isEmpty()}.
	 */
	@Test
	public void testInitializedListIsNotEmpty() {
		initializeList();
		assertFalse(listUnderTest.isEmpty(), "A list instance containing elements should not be empty");
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#clear()}.
	 */
	@Test
	public void testClearOnEmptyList() {
		listUnderTest.clear();
		assertTrue(listUnderTest.isEmpty(), "An empty list instance that is cleared should not contain any item");
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#clear()}.
	 */
	@Test
	public void testClearInitializedList() {
		initializeList();
		listUnderTest.clear();
		assertTrue(listUnderTest.isEmpty());
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#numberOfElements()}.
	 */
	@Test
	public void testNumberOfElementsOnEmptyList() {
		assertTrue(listUnderTest.numberOfElements() == 0);
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#numberOfElements()}.
	 */
	@Test
	public void testNumberOfElementsOnInitializedList() {
		initializeList();
		assertTrue(listUnderTest.numberOfElements() == 5);
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#insertFirst()}.
	 */
	@Test
	public void testInsertFirstOnEmptyList() {
		listUnderTest.insertFirst(42);
		assertTrue(42 == listUnderTest.getFirst());
		assertTrue(listUnderTest.numberOfElements() == 1);
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#insertFirst()}.
	 */
	@Test
	public void testInsertFirstOnInitializedList() {
		initializeList();
		listUnderTest.insertFirst(42);
		assertTrue(listUnderTest.getFirst() == 42);
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#insertLast()}.
	 */
	@Test
	public void testInsertLastOnEmptyList() {
		listUnderTest.insertLast(42);
		assertTrue(listUnderTest.getLast() == 42);
		assertTrue(listUnderTest.numberOfElements() == 1);
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#insertLast()}.
	 */
	@Test
	public void testInsertLastOnInitializedList() {
		initializeList();
		listUnderTest.insertLast(42);
		assertTrue(listUnderTest.getLast() == 42);
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#removeFirst()}.
	 */
	@Test
	public void testRemoveFirstOnEmptyList() {
		assertThrows(ListEmptyException.class, () -> listUnderTest.removeFirst(),
				"removeFirst() on empty list should throw ListEmptyException");
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#removeFirst()}.
	 */
	@Test
	public void testRemoveFirstOnInitializedList() {
		initializeList();
		assertTrue(listUnderTest.removeFirst() == 1);
		assertTrue(listUnderTest.numberOfElements() == 4);
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#removeLast()}.
	 */
	@Test
	public void testRemoveLastOnEmptyList() {
		assertThrows(ListEmptyException.class, () -> listUnderTest.removeLast(),
				"removeLast() on empty list should throw ListEmptyException");
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#removeLast()}.
	 */
	@Test
	public void testRemoveLastOnInitializedList() {
		initializeList();
		assertTrue(listUnderTest.removeLast() == 5);
		assertTrue(listUnderTest.numberOfElements() == 4);
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#getFirst()}.
	 */
	@Test
	public void testGetFirstOnEmptyList() {
		assertThrows(ListEmptyException.class, () -> listUnderTest.getFirst(),
				"GetFirst() on empty list should throw ListEmptyException");
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#getFirst()}.
	 */
	@Test
	public void testGetFirstOnInitializedList() {
		initializeList();
		assertEquals(1, listUnderTest.getFirst(), "GetFirst() should return first element in list");
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#getLast()}.
	 */
	@Test
	public void testGetLastOnEmptyList() {
		assertThrows(ListEmptyException.class, () -> listUnderTest.getLast(),
				"getLast() on empty list should throw ListEmptyException");
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#getLast()}.
	 */
	@Test
	public void testGetLastOnInitializedList() {
		initializeList();
		assertTrue(listUnderTest.getLast() == 5);
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#toStringRecursive()}.
	 * 
	 */
	@Test
	public void testToStringRecursiveEmptyList() {
		assertTrue(listUnderTest.toStringRecursive().equals("[]"));
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#toStringRecursive()}.
	 * 
	 */
	@Test
	public void testToStringRecursiveInitializedList() {
		initializeList();
		assertTrue(listUnderTest.toStringRecursive().equals("[1,2,3,4,5]"));
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#toStringReverseRecursive()}.
	 * 
	 */
	@Test
	public void testToStringReverseRecursiveEmptyList() {
		assertTrue(listUnderTest.toStringReverseRecursive().equals("[]"));
	}

	/**
	 * Test method for {@link se.hig.aod.lab0.LinkedList#toStringReverseRecursive()}.
	 * 
	 */
	@Test
	public void testToStringReverseRecursiveInitializedList() {
		initializeList();
		assertTrue(listUnderTest.toStringReverseRecursive().equals("[5,4,3,2,1]"));
	}

	private void initializeList() {
		for (int i = 0; i < fixture.length; i++) {
			listUnderTest.insertLast(fixture[i]);
		}
	}

}
