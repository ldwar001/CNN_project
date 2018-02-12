import numpy as np
from sklearn.cluster import KMeans
y = np.loadtxt('/Users/lalithadwarapudi/Desktop/projects_masters/features_500_images',delimiter=",")
print("Printing y")
print(y[1])
kmeans = KMeans(n_clusters=3)
# Fitting with inputs
kmeans = kmeans.fit(y)
# Predicting the clusters
labels = kmeans.predict(y)
# Getting the cluster centers
C = kmeans.cluster_centers_
print("centroids from sci-kit")
print(C)
np.savetxt('/Users/lalithadwarapudi/Desktop/projects_masters/centroids_k-means', C, delimiter=',')
