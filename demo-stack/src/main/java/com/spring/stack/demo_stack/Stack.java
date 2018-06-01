package com.spring.stack.demo_stack;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class Stack.
 */
@SuppressWarnings("PMD")
public class Stack {

	/** Logger for this class. */
	private static final Logger LOGGER = LogManager.getLogger(Stack.class.getName());

	/** The size. */
	private int size;

	/** The stack. */
	private List<Integer> stackList;

	/** The top. */
	private int top;

	/**
	 * Sets the size.
	 *
	 * @param size
	 *            the new size
	 */
	public void setSize(final int size) {
		this.size = size;
	}

	/**
	 * Sets the stack.
	 *
	 * @param stack
	 *            the new stack
	 */
	public void setStack(final List<Integer> stack) {
		stackList = stack;
	}

	/**
	 * Push.
	 *
	 * @param element
	 *            the element
	 * @throws StackOverflowError
	 *             the stack overflow error
	 */
	public void push(final int element) throws StackOverflowError {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("push(int) - start"); //$NON-NLS-1$
		}

		if (top >= size) {
			throw new StackOverflowError("stack overflow");
		} else {
			stackList.add(top, element);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("push(int) - {}" + "element pushed"); //$NON-NLS-1$ //$NON-NLS-2$
			}
			top++;
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("push(int) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * Pop.
	 *
	 * @throws StackOverflowError
	 *             the stack overflow error
	 */
	public void pop() throws StackOverflowError {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("pop() - start"); //$NON-NLS-1$
		}

		if (top <= 0) {
			throw new StackOverflowError("stack underflow");
		} else {
			top--;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("pop() - {}" + "poped element :" + stackList.remove(top)); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("pop() - end"); //$NON-NLS-1$
		}
	}

	/**
	 * Push.
	 *
	 * @param index
	 *            the index
	 * @param element
	 *            the element
	 * @throws IndexOutOfBoundsException
	 *             the index out of bounds exception
	 */
	public void push(final int index, final int element) throws IndexOutOfBoundsException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("push(int, int) - start"); //$NON-NLS-1$
		}

		if (index > stackList.size()) {
			throw new IndexOutOfBoundsException("index must be less than or equal to size");
		} else if (index < 0) {
			throw new IndexOutOfBoundsException("index must be greater than or equal to zero");
		} else {
			stackList.add(index, element);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("push(int, int) - {}" + "element pushed"); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("push(int, int) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * Pop.
	 *
	 * @param index
	 *            the index
	 * @throws IndexOutOfBoundsException
	 *             the index out of bounds exception
	 */
	public void pop(final int index) throws IndexOutOfBoundsException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("pop(int) - start"); //$NON-NLS-1$
		}

		if (index >= stackList.size()) {
			throw new IndexOutOfBoundsException("index must be less than size");
		} else if (stackList.isEmpty() || index < 0) {
			throw new IndexOutOfBoundsException("index must be greater than or equal to zero");
		} else {
			stackList.remove(index);
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("pop(int) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * Rearrange.
	 *
	 * @param destinationIndex
	 *            the destination index
	 * @param element
	 *            the element
	 * @throws IndexOutOfBoundsException
	 *             the index out of bounds exception
	 */
	public void rearrange(final int destinationIndex, final int element) throws IndexOutOfBoundsException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("rearrange(int, int) - start"); //$NON-NLS-1$
		}

		final int sourceIndex = stackList.indexOf(element);
		if (sourceIndex == -1) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("element not found"); //$NON-NLS-1$
			}

		} else {
			stackList.remove((Object) element);
			stackList.add(destinationIndex, element);
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("rearrange(int, int) - end"); //$NON-NLS-1$
		}
	}

	/**
	 * Display.
	 */
	public void display() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("display() - start"); //$NON-NLS-1$
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("printing stack ..."); //$NON-NLS-1$
		}
		if (stackList.isEmpty()) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("display() - {}" + "nothing to display ! stack is empty"); //$NON-NLS-1$ //$NON-NLS-2$
			}
		} else {
			for (final int element : stackList) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(element + " "); //$NON-NLS-1$
				}
			}
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("display() - {}"); //$NON-NLS-1$
			}
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("display() - end"); //$NON-NLS-1$
		}
	}
}
