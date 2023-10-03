package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {

		if(isFull()){
			throw new QueueOverflowException();
		}
		try {
			this.stack1.push(element);
		} catch (Exception e) {
			throw new QueueOverflowException();
		}
	
		
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()){
			throw new QueueUnderflowException();
		}
		try {
			shiftStacks();
			T retorno = stack2.top();
			stack2.pop();
			return retorno;
		} catch (Exception e) {
			throw new QueueUnderflowException();
		}
		
	}

	@Override
	public T head() {	
		shiftStacks();
		return stack2.top();
			
	}
	

	@Override
	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}

	@Override
	public boolean isFull() {
		shiftStacks();
		return stack2.isFull();
	}

	private void shiftStacks(){
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				try {
					stack2.push(stack1.pop());	
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}

	}

}