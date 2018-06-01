package com.spring.stack.demo_stack;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// TODO: Auto-generated Javadoc
/**
 * The Class App.
 */
@SuppressWarnings("PMD")
public class App {

	/** Logger for this class. */
	private static final Logger LOGGER = LogManager.getLogger(App.class.getName());

	/**
	 * Menu.
	 */
	public static void menu() {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("1/push"); //$NON-NLS-1$
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("2/pop"); //$NON-NLS-1$
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("3/push at index"); //$NON-NLS-1$
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("4/pop at index"); //$NON-NLS-1$
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("5/rearrange"); //$NON-NLS-1$
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("6/display"); //$NON-NLS-1$
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("7/exit"); //$NON-NLS-1$
		}

	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("main(String[]) - start"); //$NON-NLS-1$
		}

		Scanner scanner = null;
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("please enter size of stack"); //$NON-NLS-1$
			}
			final ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
			scanner = new Scanner(System.in, "UTF-8");
			ctx.getBean("size1", scanner.nextInt());
			final Stack stack = (Stack) ctx.getBean("stack");
			char repeat = 'y';
			while (repeat == 'y' || repeat == 'Y') {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("main(String[]) - {}" ); //$NON-NLS-1$
				}
				menu();
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug( "please enter your choice"); //$NON-NLS-1$
				}
				switch (scanner.nextInt()) {
				case 1:
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug("enter element to be pushed"); //$NON-NLS-1$
					}
					stack.push(scanner.nextInt());
					break;
				case 2:
					stack.pop();
					break;
				case 3:
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug("enter index you want to push"); //$NON-NLS-1$
					}
					final int index = scanner.nextInt();
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug("enter element to be pushed"); //$NON-NLS-1$
					}
					final int element = scanner.nextInt();
					stack.push(index, element);
					break;
				case 4:
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug("enter index you want to pop"); //$NON-NLS-1$
					}
					stack.pop(scanner.nextInt());
					break;
				case 5:
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug("enter destination index"); //$NON-NLS-1$
					}
					final int dIndex = scanner.nextInt();
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug("enter element to be rearranged"); //$NON-NLS-1$
					}
					stack.rearrange(dIndex, scanner.nextInt());
					break;
				case 6:
					stack.display();
					break;
				default:
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug("please enter correct choice"); //$NON-NLS-1$
					}
					break;
				}
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("do you want to continue Y or N ?"); //$NON-NLS-1$
				}
				repeat = scanner.next().charAt(0);
			}
		} catch (final IndexOutOfBoundsException | StackOverflowError ex) {
			LOGGER.error("main(String[])", ex); //$NON-NLS-1$

			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(ex.getMessage());
			}
		} catch (final InputMismatchException e) {
			LOGGER.error("main(String[])", e); //$NON-NLS-1$

			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("enter valid input value"); //$NON-NLS-1$
			}
		} finally {
			scanner.close();
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("main(String[]) - end"); //$NON-NLS-1$
		}
	}
}
