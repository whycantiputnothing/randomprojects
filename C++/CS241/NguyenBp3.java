import java.util.*;
import java.util.Map.Entry;

public class NguyenBp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NguyenBp3 b = new NguyenBp3();
		DirectedGraph g = b.new DirectedGraph();
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");
		g.addVertex("H");
		g.addVertex("K");
		g.addVertex("L");
		g.addVertex("M");
		g.addVertex("N");
		g.addEdge("A", "B", 2);
		g.addEdge("B", "F", 1);
		g.addEdge("B", "C", 3);
		g.addEdge("C", "D", 2);
		g.addEdge("C", "G", 2);
		g.addEdge("E", "A", 3);
		g.addEdge("E", "F", 2);
		g.addEdge("F", "L", 1);
		g.addEdge("G", "F", 2);
		g.addEdge("G", "H", 3);
		g.addEdge("H", "N", 2);
		g.addEdge("K", "E", 1);
		g.addEdge("K", "L", 3);
		g.addEdge("L", "M", 1);
		g.addEdge("M", "N", 1);

		Scanner in = new Scanner(System.in);
		String s = "";
		String s1 = "";
		int a = 0;
		System.out.println("Part Two: ");
		System.out.print("Vertex to delete: ");
		s = in.next();
		g.delete(s);
		System.out.print("Vertex to add: ");
		s = in.next();
		g.addVertex(s);
		System.out.print("Edge to add: ");
		s = in.next();
		a = in.nextInt();
		s1 = in.next();
		g.addEdge(s, s1, a);
		System.out.print("Edge to add: ");
		s = in.next();
		a = in.nextInt();
		s1 = in.next();
		g.addEdge(s, s1, a);
		g.printEdges();
		g.printFromA();
		g.printShortestPath();
		in.close();
		System.exit(0);
	}

	public class DirectedGraph {
		Map<String, Vertex> vertices;
		int edgeCount;

		public DirectedGraph() {
			vertices = new HashMap<String, Vertex>();
			edgeCount = 0;
		}

		public boolean addVertex(String vertexLabel) {
			Vertex isDuplicate = vertices.put(vertexLabel, new Vertex(vertexLabel));
			return isDuplicate == null;
		}

		public boolean addEdge(String begin, String end, int edgeWeight) {
			boolean result = false;

			Vertex beginVertex = vertices.get(begin);
			Vertex endVertex = vertices.get(end);

			if ((beginVertex != null) && (endVertex != null)) {
				result = beginVertex.connect(endVertex, edgeWeight);
			}

			if (result)
				edgeCount++;

			return result;
		}

		public boolean hasEdge(String begin, String end) {
			boolean found = false;

			Vertex beginVertex = vertices.get(begin);
			Vertex endVertex = vertices.get(end);

			if ((beginVertex != null) && (endVertex != null)) {
				Iterator<Vertex> neighbors = beginVertex.getNeightborIterator();

				while (!found && neighbors.hasNext()) {
					Vertex nextNeighbor = neighbors.next();
					if (endVertex.equals(nextNeighbor))
						found = true;
				}
			}

			return found;

		}

		public void resetVertices() {
			Iterator<Vertex> vertexIterator = vertices.values().iterator();
			while (vertexIterator.hasNext()) {
				Vertex nextVertex = vertexIterator.next();
				nextVertex.visited = false;
				nextVertex.cost = 0;
				nextVertex.previousVertex = null;
			}

		}

		public void delete(String s) {
			Iterator<Entry<String, Vertex>> it = vertices.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, Vertex> pair = (Map.Entry<String, Vertex>) it.next();
				for (int i = 0; i < pair.getValue().edgeList.size(); i++) {
					if (pair.getValue().edgeList.get(i).vertex.label.equals(s)) {
						pair.getValue().edgeList.remove(i);
						edgeCount--;
						i--;
					}

				}
			}
			vertices.remove(s);
		}

		public void printEdges() {
			System.out.println();
			System.out.println("Part Three: ");

			for (Map.Entry<String, Vertex> entry : vertices.entrySet()) {
				String buffer = "";
				String v = entry.getKey();
				for (Edge a : entry.getValue().edgeList) {
					buffer += v + " " + a.weight + " " + a.vertex.label + ", ";
				}
				if (buffer.endsWith(", ")) {
					buffer = buffer.substring(0, buffer.length() - 2);
					System.out.println(buffer);
				}
				else {
					System.out.println(v + " has no edges");
				}
			}
		}

		public void printFromA() {
			System.out.println();
			System.out.println("Part Four: ");
			System.out.print("Vertices that can be reached from A: ");
			List<String> reach = new ArrayList<String>();
			Stack<String> st = new Stack<String>();
			st.push("A");
			while (!st.empty()) {
				Vertex v = vertices.get(st.pop());
				for (Edge e : v.edgeList) {
					st.push(e.vertex.label);
					if (!reach.contains(e.vertex.label))
						reach.add(e.vertex.label);
				}
			}
			Collections.sort(reach);
			System.out.println(Arrays.toString(reach.toArray()));
		}

		public int getCheapestPath(String oV, String eV) {
			resetVertices();
			Vertex originVertex = vertices.get(oV);
			Vertex endVertex = vertices.get(eV);
			boolean done = false;
			PriorityQueue<EntryPQ> priorityQueue = new PriorityQueue<EntryPQ>(idComparator);
			priorityQueue.add(new EntryPQ(originVertex, 0, null));

			while (!done && !priorityQueue.isEmpty()) {
				EntryPQ frontEntry = priorityQueue.remove();
				Vertex frontVertex = frontEntry.originVertex;

				Iterator<Vertex> neighbors = frontVertex.getNeightborIterator();

				if (!frontVertex.visited) {
					frontVertex.visited = true;
					frontVertex.cost = frontEntry.cost;
					frontVertex.previousVertex = frontEntry.previous;

					if (frontVertex.equals(endVertex))
						done = true;
					else {
						while (neighbors.hasNext()) {
							Vertex nextNeighbor = neighbors.next();
							int weightOfEdgeToNeighbor = 0;
							for (Edge e : frontVertex.edgeList) {
								if (nextNeighbor.equals(e.vertex))
									weightOfEdgeToNeighbor = e.weight;
							}

							if (!nextNeighbor.visited) {
								int nextCost = weightOfEdgeToNeighbor + frontVertex.cost;
								priorityQueue.add(new EntryPQ(nextNeighbor, nextCost, frontVertex));
							}
						}
					}

				}
			}

			return endVertex.cost;
		}

		public Comparator<EntryPQ> idComparator = new Comparator<EntryPQ>() {

			@Override
			public int compare(EntryPQ c1, EntryPQ c2) {
				return (int) (c1.cost - c2.cost);
			}
		};

		public void printShortestPath() {
			System.out.println();
			System.out.println("Part Five: ");
			String s = "";
			System.out.println("Paths from A: ");
			for (String key : vertices.keySet()) {
				if (!key.equals("A")) {
					int cheap = getCheapestPath("A", key);
					if (cheap == 0)
						s = "no path";
					else
						s = "length " + String.valueOf(cheap);
					System.out.println("to " + key + ": " + s);
				}
			}
		}

	}

	public class Vertex {
		String label;
		List<Edge> edgeList;
		boolean visited;
		Vertex previousVertex;
		int cost;

		public Vertex(String vertexLabel) {
			label = vertexLabel;
			edgeList = new LinkedList<Edge>();
			visited = false;
			previousVertex = null;
			cost = 0;
		}

		public boolean connect(Vertex endVertex, int edgeWeight) {
			boolean result = false;
			if (!this.equals(endVertex)) {
				Iterator<Vertex> neighbors = this.getNeightborIterator();
				boolean duplicateEdge = false;

				while (!duplicateEdge && neighbors.hasNext()) {
					Vertex nextNeighbor = neighbors.next();
					if (endVertex.equals(nextNeighbor))
						duplicateEdge = true;
				}

				if (!duplicateEdge) {
					edgeList.add(new Edge(endVertex, edgeWeight));
					result = true;
				}
			}
			return result;
		}

		public Iterator<Vertex> getNeightborIterator() {
			return new neighborIterator();
		}

		private class neighborIterator implements Iterator<Vertex> {
			Iterator<Edge> edges;

			private neighborIterator() {
				edges = edgeList.iterator();
			}

			public boolean hasNext() {
				return edges.hasNext();
			}

			public Vertex next() {
				Vertex nextNeighbor = null;

				if (edges.hasNext()) {
					Edge edgeToNextNeighbor = edges.next();
					nextNeighbor = edgeToNextNeighbor.vertex;
				}

				else
					throw new NoSuchElementException();
				return nextNeighbor;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}

		}

		public boolean equals(Object other) {
			boolean result;
			if ((other == null) || (getClass() != other.getClass()))
				result = false;
			else {
				Vertex otherVertex = (Vertex) other;
				result = label.equals(otherVertex.label);
			}
			return result;
		}

	}

	public class Edge {
		Vertex vertex;
		int weight;

		public Edge(Vertex endVertex, int edgeWeight) {
			vertex = endVertex;
			weight = edgeWeight;
		}
	}

	public class EntryPQ {
		Vertex originVertex;
		Vertex previous;
		int cost;

		public EntryPQ(Vertex origin, int weight, Vertex prev) {
			originVertex = origin;
			cost = weight;
			previous = prev;
		}
	}

}
