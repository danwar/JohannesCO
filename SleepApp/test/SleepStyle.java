//package edu.chalmers.dat255.johannesco.sleepapp.main.model;
//
//public class SleepStyle {
//	
//	private String name;
//	private long sleepTimeMillis;
//	private long wakeTimeMillis;
//
//
//	public SleepStyle(String name, long sleepTimeMillis, long wakeTimeMillis) {
//		super();
//		this.name = name;
//		this.sleepTimeMillis = sleepTimeMillis;
//		this.wakeTimeMillis = wakeTimeMillis;
//	}
//	
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public long getSleepTimeMillis() {
//		return sleepTimeMillis;
//	}
//	public void setSleepTimeMillis(long sleepTimeMillis) {
//		this.sleepTimeMillis = sleepTimeMillis;
//	}
//	public long getWakeTimeMillis() {
//		return wakeTimeMillis;
//	}
//	public void setWakeTimeMillis(long wakeTimeMillis) {
//		this.wakeTimeMillis = wakeTimeMillis;
//	}
//	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result
//				+ (int) (sleepTimeMillis ^ (sleepTimeMillis >>> 32));
//		result = prime * result
//				+ (int) (wakeTimeMillis ^ (wakeTimeMillis >>> 32));
//		return result;
//	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		SleepStyle other = (SleepStyle) obj;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (sleepTimeMillis != other.sleepTimeMillis)
//			return false;
//		if (wakeTimeMillis != other.wakeTimeMillis)
//			return false;
//		return true;
//	}
//}
