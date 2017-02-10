package confs;

import java.io.IOException;
import java.io.PrintWriter;

public class GenConfs {
	
	static int n = 1;
	static int [][] p = {
			{1,1,1,0,1,0,0}, // 1
			{0,1,1,1,0,1,0}, // 2
			{0,0,1,1,1,0,1}, // 3
			{1,0,0,1,1,1,0}, // 4
			{0,1,0,0,1,1,1}, // 5
			{1,0,1,0,0,1,1}, // 6
			{1,1,0,1,0,0,1}, // 7
			{0,0,0,0,0,0,0}, // 8
			{0,0,0,1,0,1,1}, // 9
			{1,0,0,0,1,0,1}, // 10
			{1,1,0,0,0,1,0}, // 11
			{0,1,1,0,0,0,1}, // 12
			{1,0,1,1,0,0,0}, // 13
			{0,1,0,1,1,0,0}, // 14
			{0,0,1,0,1,1,0}, // 15
			{1,1,1,1,1,1,1} // 16
			};
	

	
	public static void main(String[] args) {
		for (n = 1; n <= 16; n++) {
		
		String s = "<?xml version=\"1.0\"?>\n <?xml-stylesheet type=\"text/xsl\" href=\"configuration.xsl\"?>\n"+
"<configuration>\n"+
"	<property>\n"+
"    <name>hbase.cluster.distributed</name>\n"+
"    <value>false</value>\n"+
"  </property>\n"+
"	<property>\n"+
"    <name>hbase.regionserver.handler.count</name>\n"+
"    <value>"+ (p[n-1][0] == 0 ? "2" : "10") +"</value>\n"+
"  </property>\n"+
"<!-- P1 -->\n"+
"  <property>\n"+
"    <name>hfile.block.cache.size</name>\n"+
"    <value>"+ (p[n-1][1] == 0 ? "0.01" : "0.4") +"</value>\n"+
"  </property>\n"+
"  <property>\n"+
"    <name>hbase.regionserver.global.memstore.size</name>\n"+
"    <value>"+ (p[n-1][2] == 0 ? "0.2" : "0.4") +"</value>\n"+
"  </property>\n"+
"  <property>\n"+
"    <name>hbase.hstore.blockingStoreFiles</name>\n"+
"    <value>"+ (p[n-1][3] == 0 ? "5" : "50") +"</value>\n"+
"  </property>\n"+
"  <property>\n"+
"    <name>hbase.hregion.memstore.block.multiplier</name>\n"+
"    <value>"+ (p[n-1][4] == 0 ? "2" : "4") +"</value>\n"+
"  </property>\n"+
"  <property>\n"+
"    <name>hbase.regionserver.checksum.verify</name>\n"+
"    <value>"+ (p[n-1][5] == 0 ? "false" : "true") +"</value>\n"+
"  </property>\n"+
"  <property>\n"+
"    <name>hbase.ipc.server.num.callqueue</name>\n"+
"    <value>"+ (p[n-1][6] == 0 ? "0" : "0.8") +"</value>\n"+
"  </property>\n"+
"</configuration>\n";
		try{
		    PrintWriter writer = new PrintWriter(n + ".xml", "UTF-8");
		    writer.println(s);
		    writer.close();
		} catch (IOException e) {
		   // do something
		}
		
		}
		
	}
}
