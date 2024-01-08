import java.util.*;
import java.io.*;

public class Lucknow_Metro
{
	public class Vertex
    {
        HashMap<String,Integer>nbrs=new HashMap<>();
    }

	static HashMap<String,Vertex> vtces;
	
	public Lucknow_Metro()
	{
		vtces=new HashMap<>();
	}    

    public int numVertex() 
	{
		return this.vtces.size();
	}

    public boolean containsVertex(String vname)
    {
        return this.vtces.containsKey(vname);
    }

    public void addVertex(String vname) 
	{
		Vertex vtx = new Vertex();
		vtces.put(vname, vtx);
	}

    public void removeVertex(String vname) 
	{
		Vertex vtx = vtces.get(vname);
		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());
		for (String key : keys) 
		{
			Vertex nbrVtx = vtces.get(key);
			nbrVtx.nbrs.remove(vname);
		}
		vtces.remove(vname);
	}
		
	public int numEdges() 
	{
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		int count = 0;
		for (String key : keys) 
		{
			Vertex vtx = vtces.get(key);
			count = count + vtx.nbrs.size();
		}
		return count / 2;
	}

    public boolean containsEdge(String vname1, String vname2) 
	{
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);
		
		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) 
		return false;		
		return true;
	}

	public void addEdge(String vname1, String vname2, int value) 
	{
		Vertex vtx1 = vtces.get(vname1); 
		Vertex vtx2 = vtces.get(vname2); 
		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) 
		return;
		vtx1.nbrs.put(vname2, value);
		vtx2.nbrs.put(vname1, value);
	}

    public void removeEdge(String vname1, String vname2) 
	{
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);			
		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) 
		{
			return;
		}
		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);
	}


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    

    public static void Create_Metro_Map(Lucknow_Metro lm)
    {
        lm.addVertex("Munshipulia~R");
        lm.addVertex("Indira Nagar~R");
        lm.addVertex("Bhootnath Market~R");
        lm.addVertex("Lekhraj Market~R");
        lm.addVertex("Badshah Nagar~R");
        lm.addVertex("IT College~R");
        lm.addVertex("Vishwavidyalaya~R");
        lm.addVertex("KD Singh Stadium~R");
        lm.addVertex("Hazratganj~R");
        lm.addVertex("Sachivalaya~R");
        lm.addVertex("Hussainganj~R");
        lm.addVertex("Charbagh~RB");
		lm.addVertex("Alambagh~R");
		lm.addVertex("Alambagh Bus Stand~R");
		lm.addVertex("Singar Nagar~R");
		lm.addVertex("Krishna Nagar~R");
		lm.addVertex("Transport Nagar~R");
		lm.addVertex("Amausi~R");
        lm.addVertex("CCS Airport~R");
		lm.addVertex("Vasant Kunj~B");
		lm.addVertex("Sarfarazganj~B");
		lm.addVertex("Medical Crossing~B");
		lm.addVertex("City Railway Station~B");
        lm.addVertex("Aminabad~B");
        lm.addVertex("Thankurganj~B");
        lm.addVertex("Nawabganj~B");
        
        lm.addEdge("Munshipulia~R", "Indira Nagar~R", 5);
        lm.addEdge("Indira Nagar~R", "Bhootnath Market~R", 4);
        lm.addEdge("Bhootnath Market~R","Lekhraj Market~R", 6);
        lm.addEdge("Lekhraj Market~R", "Badshah Nagar~R", 5);
        lm.addEdge("Badshah Nagar~R", "IT College~R", 5);
        lm.addEdge("IT College~R", "Vishwavidyalaya~R", 4);
        lm.addEdge("Vishwavidyalaya~R", "KD Singh Stadium~R", 8);
        lm.addEdge("KD Singh Stadium~R","Hazratganj~R", 6);
        lm.addEdge("Hazratganj~R", "Sachivalaya~R", 9);
        lm.addEdge("Sachivalaya~R", "Hussainganj~R", 4);
        lm.addEdge("Hussainganj~R", "Charbagh~RB", 7);
        lm.addEdge("Charbagh~RB", "Alambagh~R", 6);
		lm.addEdge("Alambagh~R", "Alambagh Bus Stand~R", 7);
		lm.addEdge("Alambagh Bus Stand~R", "Singar Nagar~R",5);
		lm.addEdge("Singar Nagar~R", "Krishna Nagar~R", 5);
		lm.addEdge("Krishna Nagar~R", "Transport Nagar~R", 6);
		lm.addEdge("Transport Nagar~R", "Amausi~R", 5);
		lm.addEdge("Amausi~R", "CCS Airport~R", 7);
		lm.addEdge("Vasant Kunj~B", "Sarfarazganj~B", 10);
		lm.addEdge("Sarfarazganj~B", "Medical Crossing~B", 4);
		lm.addEdge("Medical Crossing~B", "City Railway Station~B", 8);
		lm.addEdge("City Railway Station~B", "Nawabganj~B", 6);
        lm.addEdge("Nawabganj~B","Thankurganj~B",5);
        lm.addEdge("Thankurganj~B","Aminabad~B",8);
        lm.addEdge("Aminabad~B","Charbagh~RB", 6);

    }

    public void display_Stations()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        ArrayList<String>keys=new ArrayList<>(vtces.keySet());
        int i=1;
        for(String key:keys)
        {
            System.out.println(i+". "+key);
            i++;
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void display_Map()
    {
        System.out.println("\t Lucknow Metro Map");
        System.out.println("\t-------------------");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        ArrayList<String>keys=new ArrayList<>(vtces.keySet());
        for(String key:keys)
        {
            String str=key+" =>\n";
            Vertex vtx=vtces.get(key);
            ArrayList<String>vtxnbrs=new ArrayList<>(vtx.nbrs.keySet());
            for(String nbr:vtxnbrs)
            {
                str=str+"\t"+nbr+"\t";
                if(nbr.length()<16)
                str = str + "\t";
                if (nbr.length()<8)
    			str = str + "\t";
                str = str + vtx.nbrs.get(nbr) + "\n";
            }
            System.out.println(str);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public boolean hasPath(String vname1,String vname2,HashMap<String, Boolean> processed)
    {
        if(containsEdge(vname1,vname2))
        return true;
        //marking as done
        processed.put(vname1,true);
        Vertex vtx=vtces.get(vname1);
        ArrayList<String>nbrs=new ArrayList<>(vtx.nbrs.keySet());
        for(String nbr:nbrs)
        {
            if(!processed.containsKey(nbr))
            {
                if(hasPath(nbr, vname2, processed))
                return true;
            }
        }
        return false;
    }

    private class DijkstraPair implements Comparable<DijkstraPair> 
	{
		String vname;
		String psf;
		int cost;
		@Override
		public int compareTo(DijkstraPair dp) 
		{
			return dp.cost - this.cost;
		}
	}
    public int dijkstra(String src, String des, boolean nan)
    {
        int val = 0;
		ArrayList<String> ans = new ArrayList<>();
		HashMap<String, DijkstraPair> map = new HashMap<>();
		Heap<DijkstraPair> heap = new Heap<>();
		for (String key : vtces.keySet()) 
		{
            DijkstraPair np = new DijkstraPair();
			np.vname = key;
			np.cost = Integer.MAX_VALUE;
			if (key.equals(src)) 
			{
				np.cost = 0;
				np.psf = key;
			}
			heap.add(np);
			map.put(key, np);
		}

        while (!heap.isEmpty()) 
		{
			DijkstraPair rp = heap.remove();			
			if(rp.vname.equals(des))
			{
				val = rp.cost;
				break;
			}			
			map.remove(rp.vname);
			ans.add(rp.vname);				
			Vertex v = vtces.get(rp.vname);
			for (String nbr : v.nbrs.keySet()) 
			{
				if (map.containsKey(nbr)) 
				{
					int oc = map.get(nbr).cost;
					Vertex k = vtces.get(rp.vname);
					int nc;
					if(nan)
						nc = rp.cost + 120 + 40*k.nbrs.get(nbr);
					else
						nc = rp.cost + k.nbrs.get(nbr);
					if (nc < oc) 
					{
						DijkstraPair gp = map.get(nbr);
						gp.psf = rp.psf + nbr;
						gp.cost = nc;
						heap.updatePriority(gp);
					}
				}
			}
		}
		return val;
    }

    public ArrayList<String> get_Interchanges(String str)
    {
        ArrayList<String> ar = new ArrayList<>();
		String res[] = str.split("  ");
		ar.add(res[0]);
		int count = 0;
		for(int i=1;i<res.length-1;i++)
		{
			int index = res[i].indexOf('~');
			String s = res[i].substring(index+1);
			
			if(s.length()==2)
			{
				String prev = res[i-1].substring(res[i-1].indexOf('~')+1);
				String next = res[i+1].substring(res[i+1].indexOf('~')+1);
					
				if(prev.equals(next)) 
				{
					ar.add(res[i]);
				}
				else
				{
					ar.add(res[i]+" ==> "+res[i+1]);
					i++;
					count++;
				}
			}
			else
			{
				ar.add(res[i]);
			}
		}
		ar.add(Integer.toString(count));
		ar.add(res[res.length-1]);
		return ar;
    }

    private class Pair 
	{
		String vname;
		String psf;
		int min_dis;
        int min_time;
	}
    public String Get_Minimum_Distance(String src, String dst) 
    {
        int min=Integer.MAX_VALUE;
        String ans = "";
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();

        Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src + "  ";
		sp.min_dis = 0;
		sp.min_time = 0;
        stack.addFirst(sp);

        while (!stack.isEmpty()) 
		{
			// remove a pair from stack
			Pair rp = stack.removeFirst();
			if (processed.containsKey(rp.vname)) 
			{
				continue;
			}
			processed.put(rp.vname, true);
			if (rp.vname.equals(dst)) 
			{
				int temp = rp.min_dis;
				if(temp<min) 
                {
					ans = rp.psf;						
                    min = temp;
                }
					continue;
			}

            Vertex rpvtx = vtces.get(rp.vname);
			ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
			for(String nbr : nbrs) 
			{
				if (!processed.containsKey(nbr)) 
                {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr + "  ";
					np.min_dis = rp.min_dis + rpvtx.nbrs.get(nbr); 
					stack.addFirst(np);
				}
			}
		}
		ans = ans + Integer.toString(min);
		return ans;		
    }

    public String Get_Minimum_Time(String src, String dst) 
	{
		int min = Integer.MAX_VALUE;
		String ans = "";
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();

		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src + "  ";
		sp.min_dis = 0;
		sp.min_time = 0;
		stack.addFirst(sp);

		while (!stack.isEmpty()) 
        {
			Pair rp = stack.removeFirst();
			if (processed.containsKey(rp.vname)) 
			continue;
			processed.put(rp.vname, true);
			//if there exists a direct edge b/w removed pair and destination vertex
			if (rp.vname.equals(dst)) 
			{
				int temp = rp.min_time;
				if(temp<min) 
                {
					ans = rp.psf;
					min = temp;
				}
					continue;
			}

            Vertex rpvtx = vtces.get(rp.vname);
			ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
			for (String nbr : nbrs) 
			{
				if (!processed.containsKey(nbr)) 
                {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr + "  ";
					np.min_time = rp.min_time + 120 + 40*rpvtx.nbrs.get(nbr); 
                    stack.addFirst(np);
				}
			}
		}
		Double minutes = Math.ceil((double)min / 60);
		ans = ans + Double.toString(minutes);
		return ans;
    }
		


    public static void main(String Args[])
    {
        Lucknow_Metro lm=new Lucknow_Metro();
        Create_Metro_Map(lm);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\n\t\t\t***WELCOME TO THE LUCKNOW METRO APPLICATION***");
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.println("\t\t\t\t~~~LIST OF ACTIONS~~~\n\n");
            System.out.println("1. List all the stations in the Map");
            System.out.println("2. Show the Metro Map");
            System.out.println("3. Get the shortest Distance from a 'SOURCE' station to 'DESTINATION' station");
            System.out.println("4. Get the shortest Time to reach from a 'SOURCE' station to 'DESTINATION' station");
            System.out.println("5. Get shortest path (Distance wise) to reach from a 'SOURCE' station to 'DESTINATION' station");
            System.out.println("6. Get shortest path (Time wise) to reach from a 'SOURCE' station to 'DESTINATION' station");
            System.out.println("7. Exit the MENU");
            System.out.println("\nENTER YOUR CHOICE FROM THE ABOVE LIST (1 TO 7) :");
            int choice=-1;
            try
            {
                choice=sc.nextInt();
            }
            catch(Exception e)
            {
                //default in switch case will handle it
            }
            System.out.println("************************************************************************************************************************");
            if(choice==7)
            { 
                System.out.println("************************************************************************************************************************");
                System.exit(0);
            }
            switch(choice)
            {
                case 1: lm.display_Stations();
                        break;

                case 2: lm.display_Map();
                        break;

                case 3: ArrayList<String>keys=new ArrayList<>(vtces.keySet());
                        lm.display_Stations();
                        String st1="",st2="";
                            System.out.println("Enter the Source station serial no.:");
                            st1=keys.get(sc.nextInt()-1);
                            System.out.println("Enter the Destination station serial no.:");
                            st2=keys.get(sc.nextInt()-1);
                        
                        HashMap<String,Boolean>processed=new HashMap<>();
                        if(!lm.containsVertex(st1) || !lm.containsVertex(st2) || !lm.hasPath(st1,st2,processed))
                        System.out.println("Inputs are INVALID !!");
                        else
                        System.out.println("Shortest Distance from "+st1+" to "+st2+" is "+lm.dijkstra(st1,st2,false)+"km.\n\n");
                        break;

                case 4: ArrayList<String>keysss=new ArrayList<>(vtces.keySet());
                        lm.display_Stations();
                        System.out.println("Enter the Source station serial no.: ");
                        String sat1=keysss.get(sc.nextInt()-1);
                        System.out.println("Enter the Destination station serial no.: ");
                        String sat2=keysss.get(sc.nextInt()-1);
                        System.out.println("Shortest time from "+sat1+" to "+sat2+" is "+lm.dijkstra(sat1,sat2,true)/60+" minutes.\n\n");
                        break;

                case 5: ArrayList<String>keyss=new ArrayList<>(vtces.keySet());
                        lm.display_Stations();
                        System.out.println("Enter the Source station: ");
                        String s1=keyss.get(sc.nextInt()-1);
                        System.out.println("Enter the Destination station: ");
                        String s2=keyss.get(sc.nextInt()-1);
                        HashMap<String,Boolean>processed2=new HashMap<>();

                        if(!lm.containsVertex(s1) || !lm.containsVertex(s2) || !lm.hasPath(s1, s2, processed2))
						System.out.println("Inputs are INVALID !!");
					    else 
					    {
                            ArrayList<String>str=lm.get_Interchanges(lm.Get_Minimum_Distance(s1, s2));
                            int len=str.size();
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("Sorce Station : " + s1);
						    System.out.println("Destination Station : " + s2);
						    System.out.println("Distance : " + str.get(len-1)+"km");
                            System.out.println("\n");
                            System.out.print("START  ==>  " + str.get(0));
						    for(int i=1; i<len-3; i++)
						    {
						    	System.out.print(str.get(i)+ " ==>  ");
						    }
						    System.out.println(str.get(len-3) + "   ==>    END");
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        }
                        break;

                case 6: ArrayList<String>k=new ArrayList<>(vtces.keySet());
                        lm.display_Stations();
                        System.out.print("Enter the Source station: ");
                        String ss1=k.get(sc.nextInt()-1);
                        System.out.print("Enter the Destination station: ");
                        String ss2=k.get(sc.nextInt()-1);
                        HashMap<String, Boolean> processed3 = new HashMap<>();

				        if(!lm.containsVertex(ss1) || !lm.containsVertex(ss2) || !lm.hasPath(ss1, ss2, processed3))
				        	System.out.println("Inputs are INVALID !!");
				        else
                        {
                            ArrayList<String>str=lm.get_Interchanges(lm.Get_Minimum_Time(ss1, ss2));
                            int len=str.size();
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("Source Station : " + ss1);
                            System.out.println("Destination Station : " + ss2);
                            System.out.println("Time : " + str.get(len-1)+" minutes");
                            System.out.println("\n");
                            System.out.print("START  ==>  " + str.get(0) + " ==>  ");
						    for(int i=1; i<len-3; i++)
						    {
						    	System.out.print(str.get(i)+ " ==>  ");
						    }
						    System.out.println(str.get(len-3) + "   ==>    END");
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");						
                        }
                        break;

                default: System.out.println("Please enter a valid option! ");
                         System.out.println("The options you can choose are from 1 to 6. ");
            }
        }
	}
}