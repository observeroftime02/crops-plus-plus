package speiger.src.crops.api;

import java.util.ArrayList;
import java.util.Arrays;

public class BartTMRetardedSort {
	
	private static Object[] input,highest,lowest;
	private static sortobj[] binput,bhighest,blowest;
	private static int median;
	
	public BartTMRetardedSort(Object[] input) {
		this.input = input; 
		for(int i=0; i<input.length;++i)
		this.binput[i] = new sortobj(i,input[i]);
	}
	
	class sortobj{
		byte[] objAsByte;
		Object obj;
		long oPos,nPos;
		
		public synchronized final byte[] getObjAsByte() {
			return this.objAsByte;
		}

		public synchronized final void setObjAsByte(byte[] objAsByte) {
			this.objAsByte = objAsByte;
		}

		public synchronized final Object getObj() {
			return this.obj;
		}

		public synchronized final void setObj(Object obj) {
			this.obj = obj;
		}

		public synchronized final long getoPos() {
			return this.oPos;
		}

		public synchronized final void setoPos(long oPos) {
			this.oPos = oPos;
		}

		public synchronized final long getnPos() {
			return this.nPos;
		}

		public synchronized final void setnPos(long nPos) {
			this.nPos = nPos;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + (int) (this.nPos ^ (this.nPos >>> 32));
			result = prime * result + (int) (this.oPos ^ (this.oPos >>> 32));
			result = prime * result + ((this.obj == null) ? 0 : this.obj.hashCode());
			result = prime * result + Arrays.hashCode(this.objAsByte);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			sortobj other = (sortobj) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (this.nPos != other.nPos)
				return false;
			if (this.oPos != other.oPos)
				return false;
			if (this.obj == null) {
				if (other.obj != null)
					return false;
			} else if (!this.obj.equals(other.obj))
				return false;
			if (!Arrays.equals(this.objAsByte, other.objAsByte))
				return false;
			return true;
		}

		public sortobj(long oPos, Object object) {
			this.oPos=oPos;
			this.obj=object;
			this.objAsByte=object.toString().getBytes();
		}
		
		private BartTMRetardedSort getOuterType() {
			return BartTMRetardedSort.this;
		}
		
	}
	
	class threaded_sort extends Thread{
		 private Thread t;
		 private String threadName;
		@Override
		public void run() {
			
		}
		
		@Override
		public void start() {
			if (t == null) {
		         t = new Thread (this, threadName);
		         t.start ();
		      }
		}
	}
}
