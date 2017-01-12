package ch16.hashtable;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.sql.rowset.Predicate;

/**
 * A hash set stores an unordered collection of objects, using a hash table.
 */
public class HashSet extends AbstractSet {
	/**
	 * Constructs a hash table.
	 * 
	 * @param bucketsLength
	 *            the length of the buckets array
	 */
	public HashSet(int bucketsLength) {
		buckets = new Node[bucketsLength];
		size = 0;
	}

	/**
	 * Tests for set membership.
	 * 
	 * @param x
	 *            an object
	 * @return true if x is an element of this set
	 */
	public boolean contains(Object x) {
		int h = x.hashCode();
		if (h < 0)
			h = -h;
		h = h % buckets.length;

		Node current = buckets[h];
		while (current != null) {
			if (current.data.equals(x))
				return true;
			current = current.next;
		}
		return false;
	}

	/**
	 * Adds an element to this set.
	 * 
	 * @param x
	 *            an object
	 * @return true if x is a new object, false if x was already in the set
	 */
	public boolean add(Object x) {
		int h = x.hashCode();
		if (h < 0)
			h = -h;
		h = h % buckets.length;

		Node current = buckets[h];
		while (current != null) {
			if (current.data.equals(x))
				return false; // Already in the set
			current = current.next;
		}
		Node newNode = new Node();
		newNode.data = x;
		newNode.next = buckets[h];
		buckets[h] = newNode;
		size++;
		return true;
	}

	/**
	 * Removes an object from this set.
	 * 
	 * @param x
	 *            an object
	 * @return true if x was removed from this set, false if x was not an
	 *         element of this set
	 */
	public boolean remove(Object x) {
		int h = x.hashCode();
		if (h < 0)
			h = -h;
		h = h % buckets.length;

		Node current = buckets[h];
		Node previous = null;
		while (current != null) {
			if (current.data.equals(x)) {
				if (previous == null)
					buckets[h] = current.next;
				else
					previous.next = current.next;
				size--;
				return true;
			}
			previous = current;
			current = current.next;
		}
		return false;
	}

	/**
	 * Returns an iterator that traverses the elements of this set.
	 * 
	 * @return a hash set iterator
	 */
	public Iterator iterator() {
		return new HashSetIterator();
	}

	/**
	 * Gets the number of elements in this set.
	 * 
	 * @return the number of elements
	 */
	public int size() {
		return size;
	}

	private Node[] buckets;
	private int size;

	private class Node {
		public Object data;
		public Node next;
	}

	private class HashSetIterator implements Iterator {
		/**
		 * Constructs a hash set iterator that points to the first element of
		 * the hash set.
		 */
		public HashSetIterator() {
			current = null;
			bucket = -1;
			previous = null;
			previousBucket = -1;
		}

		public boolean hasNext() {
			if (current != null && current.next != null)
				return true;
			for (int b = bucket + 1; b < buckets.length; b++)
				if (buckets[b] != null)
					return true;
			return false;
		}

		public Object next() {
			previous = current;
			previousBucket = bucket;
			if (current == null || current.next == null) {
				// Move to next bucket
				bucket++;

				while (bucket < buckets.length && buckets[bucket] == null)
					bucket++;
				if (bucket < buckets.length)
					current = buckets[bucket];
				else
					throw new NoSuchElementException();
			} else
				// Move to next element in bucket
				current = current.next;
			return current.data;
		}

		public void remove() {
			if (previous != null && previous.next == current)
				previous.next = current.next;
			else if (previousBucket < bucket)
				buckets[bucket] = current.next;
			else
				throw new IllegalStateException();
			current = previous;
			bucket = previousBucket;
		}

		private int bucket;
		private Node current;
		private int previousBucket;
		private Node previous;

	}

}
