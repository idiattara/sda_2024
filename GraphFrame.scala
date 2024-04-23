// Import necessary libraries
import org.apache.spark.sql.SparkSession
import org.graphframes.GraphFrame

// Create a Spark session
val spark = SparkSession.builder.appName("GraphFramesExample").getOrCreate()

// Define vertices and edges as DataFrames
val vertices = spark.createDataFrame(Seq(
  (1, "Scott", 30),
  (2, "David", 40),
  (3, "Mike", 45)
)).toDF("id", "name", "age")

val edges = spark.createDataFrame(Seq(
  (1, 2, "friend"),
  (2, 3, "follow")
)).toDF("src", "dst", "relationship")

// Create a GraphFrame
val graph = GraphFrame(vertices, edges)

// Display vertices and edges
graph.vertices.show()
graph.edges.show()

// Perform Graph Queries
val aliceFriends = graph.edges.filter("src = 1").join(graph.vertices, "dst").select("dst", "name")
aliceFriends.show()

// Graph Analytics - In-degrees
val inDegrees = graph.inDegrees
inDegrees.show()

// Subgraph Creation
val subgraph = graph.filterVertices("age >= 40").filterEdges("relationship = 'friend'")
subgraph.vertices.show()
subgraph.edges.show()

// Graph Algorithms - PageRank
val pageRankResults = graph.pageRank.resetProbability(0.15).maxIter(10).run()
pageRankResults.vertices.show()
pageRankResults.edges.show()

// Stop the Spark session
spark.stop()
