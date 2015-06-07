package main.java.iitb.neo.training.algorithm.lpercp;

import java.util.Map;

import main.java.iitb.neo.training.ds.Graph;
import main.java.iitb.neo.training.ds.LRGraph;
import edu.washington.multirframework.multiralgorithm.DenseVector;
import edu.washington.multirframework.multiralgorithm.Parameters;
import edu.washington.multirframework.multiralgorithm.SparseBinaryVector;

public class Scorer {
	private Parameters params;

	public Scorer() {
	}

	// scoring on mention documents, all 2*numRelation
	public double scoreMentionRelation(Graph doc, int m, int rel,
			Map<Integer, Double> featureScoreMap) {
		double sum = 0;
		DenseVector p = params.relParameters[rel];
		sum += p.dotProduct(doc.features[m], featureScoreMap);
		return sum;
	}

	// scoring on mention documents, all 2*numRelation
	public double scoreMentionRelation(Graph doc, int m, int rel) {
		double sum = 0;
		DenseVector p = params.relParameters[rel];
		sum += p.dotProduct(doc.features[m]);
		return sum;
	}

	// need to consider additional features that are dependent on rel ...
	public SparseBinaryVector getMentionRelationFeatures(Graph doc, int m,
			int rel) {
		return doc.features[m];
	}

	public SparseBinaryVector getMentionNumRelationFeatures(LRGraph doc, int m,
			int rel) {
		return doc.numFeatures[m];
	}

	/**
	 * returns the features stored in the mth instance of the Graph
	 * @param doc
	 * @param m
	 * @param rel
	 * @return
	 */
	public SparseBinaryVector getMentionFeatures(Graph doc, int m) {
		return doc.features[m];
	}

	public void setParameters(Parameters params) {
		this.params = params;
	}
}
