# jena-system-in-jetty-debug

Test project to debug initialization of the Jena environment in a jetty-embedded app.

To reproduce the problem:

WORKS: start the server with `mvn jetty run`, then access it, `curl -v http://localhost:8080/`

DOES NOT WORK: start the server with `./run.sh`, it will throw a NPE:

```
Exception in thread "main" java.lang.ExceptionInInitializerError
	at org.apache.jena.tdb.setup.StoreParams.getDftStoreParams(StoreParams.java:123)
	at org.apache.jena.tdb.setup.DatasetBuilderStd.create(DatasetBuilderStd.java:84)
	at org.apache.jena.tdb.StoreConnection.make(StoreConnection.java:206)
	at org.apache.jena.tdb.StoreConnection.make(StoreConnection.java:213)
	at org.apache.jena.tdb.transaction.DatasetGraphTransaction.<init>(DatasetGraphTransaction.java:64)
	at org.apache.jena.tdb.sys.TDBMaker._create(TDBMaker.java:55)
	at org.apache.jena.tdb.sys.TDBMaker.createDatasetGraphTransaction(TDBMaker.java:42)
	at org.apache.jena.tdb.sys.TDBMaker.createDatasetGraphTransaction(TDBMaker.java:50)
	at org.apache.jena.tdb.TDBFactory._createDatasetGraph(TDBFactory.java:93)
	at org.apache.jena.tdb.TDBFactory.createDatasetGraph(TDBFactory.java:75)
	at org.apache.jena.tdb.TDBFactory.createDataset(TDBFactory.java:59)
	at enridaga.jenainjetty.Application.contextInitialized(Application.java:22)
	at org.eclipse.jetty.server.handler.ContextHandler.callContextInitialized(ContextHandler.java:794)
	at org.eclipse.jetty.servlet.ServletContextHandler.callContextInitialized(ServletContextHandler.java:522)
	at org.eclipse.jetty.server.handler.ContextHandler.startContext(ContextHandler.java:785)
	at org.eclipse.jetty.servlet.ServletContextHandler.startContext(ServletContextHandler.java:341)
	at org.eclipse.jetty.webapp.WebAppContext.startWebapp(WebAppContext.java:1357)
	at org.eclipse.jetty.webapp.WebAppContext.startContext(WebAppContext.java:1350)
	at org.eclipse.jetty.server.handler.ContextHandler.doStart(ContextHandler.java:734)
	at org.eclipse.jetty.servlet.ServletContextHandler.doStart(ServletContextHandler.java:258)
	at org.eclipse.jetty.webapp.WebAppContext.doStart(WebAppContext.java:512)
	at org.eclipse.jetty.util.component.AbstractLifeCycle.start(AbstractLifeCycle.java:68)
	at org.eclipse.jetty.util.component.ContainerLifeCycle.start(ContainerLifeCycle.java:132)
	at org.eclipse.jetty.server.Server.start(Server.java:405)
	at org.eclipse.jetty.util.component.ContainerLifeCycle.doStart(ContainerLifeCycle.java:114)
	at org.eclipse.jetty.server.handler.AbstractHandler.doStart(AbstractHandler.java:61)
	at org.eclipse.jetty.server.Server.doStart(Server.java:372)
	at org.eclipse.jetty.util.component.AbstractLifeCycle.start(AbstractLifeCycle.java:68)
	at enridaga.jenainjetty.Main.main(Main.java:38)
Caused by: java.lang.NullPointerException
	at org.apache.jena.tdb.sys.SystemTDB.determineFileMode(SystemTDB.java:381)
	at org.apache.jena.tdb.sys.SystemTDB.fileMode(SystemTDB.java:356)
	at org.apache.jena.tdb.setup.StoreParamsConst.<clinit>(StoreParamsConst.java:37)
	... 29 more
	```
