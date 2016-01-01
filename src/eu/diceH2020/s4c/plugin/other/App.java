package eu.diceH2020.s4c.plugin.other;

import java.util.Arrays;

public class App {
	public App() {}
	
	public int gamma;
	public  String[]  typeVm;
	public  String  provider;

	public int[] id_job;

	public double[] think;

	public int[][] cM;

	public int[][] cR;
	public double[] N;
	public int[] HUp;
	public int[] HLow;


	public  int[] NM;
	public  int[] NR;
	public   String[] Mmax ;
	public   String[] Rmax;
	public   String[] Mavg ;
	public   String[] Ravg;

	public  String[]  D;
	public  String[] SH1max;
	public  String[]  SHtypmax;
	public  String[] job_penalty;
	public    double[] R;


	public App(
			int gamma, 
			String[] typeVm, 
			String provider, 
			int[] id_job, 
			double[] think, 
			int[][] cM, 
			int[][] cR,
			double[] n, 
			int[] hUp, 
			int[] hLow, 
			int[] nM, 
			int[] nR, 
			String[] mmax, 
			String[] rmax, 
			String[] mavg,
			String[] ravg, 
			String[] d, 
			String[] sH1max, 
			String[] sHtypmax, 
			String[] job_penalty, 
			double[] r) {
		super();
		this.gamma = gamma;
		this.typeVm = typeVm;
		this.provider = provider;
		this.id_job = id_job;
		this.think = think;
		this.cM = cM;
		this.cR = cR;
		N = n;
		HUp = hUp;
		HLow = hLow;
		NM = nM;
		NR = nR;
		Mmax = mmax;
		Rmax = rmax;
		Mavg = mavg;
		Ravg = ravg;
		D = d;
		SH1max = sH1max;
		SHtypmax = sHtypmax;
		this.job_penalty = job_penalty;
		R = r;
	}


	@Override
	public String toString() {
		return "App [gamma=" + gamma + ", typeVm=" + Arrays.toString(typeVm) + ", provider=" + provider
				+ ", id_job=" + Arrays.toString(id_job) + ", think=" + Arrays.toString(think) + ", cM="
				+ Arrays.toString(cM) + ", cR=" + Arrays.toString(cR) + ", N=" + Arrays.toString(N) + ", HUp="
				+ Arrays.toString(HUp) + ", HLow=" + Arrays.toString(HLow) + ", NM=" + Arrays.toString(NM) + ", NR="
				+ Arrays.toString(NR) + ", Mmax=" + Arrays.toString(Mmax) + ", Rmax=" + Arrays.toString(Rmax)
				+ ", Mavg=" + Arrays.toString(Mavg) + ", Ravg=" + Arrays.toString(Ravg) + ", D="
				+ Arrays.toString(D) + ", SH1max=" + Arrays.toString(SH1max) + ", SHtypmax="
				+ Arrays.toString(SHtypmax) + ", job_penalty=" + Arrays.toString(job_penalty) + ", R="
				+ Arrays.toString(R) + "]";
	}


	public boolean control(int x){
		if (cM.length==x && cR.length==x && HUp.length==x && HLow.length==x && NM.length==x && NR.length==x && Mmax.length==x
				&& Rmax.length==x && SH1max.length==x && SHtypmax.length==x && D.length==x && job_penalty.length==x && R.length==x ){
			return true;
		}
		return false;
	}      


}








