Steps: 
    #1: setup helm latest version
    #2: add neo4j repo to helm:
                PS C:\Users\107316> helm list
                NAME    NAMESPACE       REVISION        UPDATED STATUS  CHART   APP VERSION
               
                PS C:\Users\107316> helm repo add neo4j https://helm.neo4j.com/neo4j
                "neo4j" has been added to your repositories
                
   #3: update helm repo:
               PS C:\Users\107316> helm repo update
               Hang tight while we grab the latest from your chart repositories...
               ...Successfully got an update from the "neo4j" chart repository
               ...Successfully got an update from the "bitnami" chart repository
               Update Complete. ⎈Happy Helming!⎈

   #4: View the available charts:
               PS C:\Users\107316> helm search repo neo4j --versions
               NAME                                    CHART VERSION   APP VERSION     DESCRIPTION
               neo4j/neo4j                             5.6.0           5.6.0           Neo4j is the world's leading graph database
               neo4j/neo4j                             5.5.0           5.5.0           Neo4j is the world's leading graph database
               neo4j/neo4j                             5.4.0           5.4.0           Neo4j is the world's leading graph database
   
   #5: install neo4j using helm now:
           PS D:\data\afero\deployments\neo4j> helm install my-neo4j neo4j/neo4j-standalone --set volumes.data.mode=defaultStorageClass -f D:/data/afero/deployments/neo4j/neo4j-deployment.yaml -n afero-work
           NAME: my-neo4j
           LAST DEPLOYED: Tue Apr 11 15:34:21 2023
           NAMESPACE: afero-work
           STATUS: deployed
           REVISION: 1
           TEST SUITE: None
           NOTES:
           Thank you for installing neo4j-standalone.
        
        Your release "my-neo4j" has been installed  in namespace "afero-work".
        
        The neo4j user's password has been set to "99opSIwLYXFAQi".To view the progress of the rollout try:
        
        $ kubectl --namespace "afero-work" rollout status --watch --timeout=600s statefulset/my-neo4j
        
        Once rollout is complete you can log in to Neo4j at "neo4j://my-neo4j.afero-work.svc.cluster.local:7687". Try:
        
        $ kubectl run --rm -it --namespace "afero-work" --image "neo4j:4.4.19" cypher-shell \
        -- cypher-shell -a "neo4j://my-neo4j.afero-work.svc.cluster.local:7687" -u neo4j -p "99opSIwLYXFAQi"
        
        Graphs are everywhere!
        
        WARNING: Passwords set using 'neo4j.password' will be stored in plain text in the Helm release ConfigMap.
        Please consider using 'neo4j.passwordFromSecret' for improved security.
        PS D:\data\afero\deployments\neo4j>