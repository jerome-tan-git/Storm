import java.util.Map;
import java.util.Random;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;


public class SimpleSpout extends BaseRichSpout {

	private SpoutOutputCollector collector;
    private static String[] info = new String[]{
        "comaple\t,12424,44w46,654,12424,44w46,654,",
        "lisi\t,435435,6537,12424,44w46,654,",
        "lipeng\t,45735,6757,12424,44w46,654,",
        "hujintao\t,45735,6757,12424,44w46,654,",
        "jiangmin\t,23545,6457,2455,7576,qr44453",
        "beijing\t,435435,6537,12424,44w46,654,",
        "xiaoming\t,46654,8579,w3675,85877,077998,",
        "xiaozhang\t,9789,788,97978,656,345235,09889,",
        "ceo\t,46654,8579,w3675,85877,077998,",
        "cto\t,46654,8579,w3675,85877,077998,",
        "zhansan\t,46654,8579,w3675,85877,077998,"};
    
    Random random=new Random();
    
	@Override
	public void nextTuple() {
		// TODO Auto-generated method stub
		try {
            String msg = info[random.nextInt(11)];
            // 调用发射方法
            collector.emit(new Values(msg));
            // 模拟等待100ms
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void open(Map arg0, TopologyContext arg1, SpoutOutputCollector arg2) {
		this.collector = collector;
		
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer arg0) {
		arg0.declare(new Fields("source"));
		
	}

}
