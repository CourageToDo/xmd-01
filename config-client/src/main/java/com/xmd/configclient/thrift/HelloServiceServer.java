package com.xmd.configclient.thrift;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Description:单向传输
 * User: xumengdi
 * Date: 2021/6/2
 */
public class HelloServiceServer {

    public static void main(String[] args) {
        try {
            // 设置服务器端口
            TServerSocket ts = new TServerSocket(9090);
            // 设置二进制协议工厂
            TBinaryProtocol.Factory protocolFactory = new TBinaryProtocol.Factory();
            //处理器关联业务实现
            HelloService.Processor<HelloService.Iface> processor = new HelloService.Processor<HelloService.Iface>(new HelloServiceImpl());
            // 1. 使用单线程标准阻塞I/O模型
            TServer.Args simpleArgs = new TServer.Args(ts);
            simpleArgs.processor(processor);
            simpleArgs.protocolFactory(protocolFactory);
            TServer server = new TSimpleServer(simpleArgs);
            System.out.println("开启thrift服务器，监听端口：9090");
            server.serve();

            // 2. 使用线程池服务模型
           /* TThreadPoolServer.Args poolArgs = new TThreadPoolServer.Args(ts);
            poolArgs.processor(processor);
            poolArgs.protocolFactory(protocolFactory);
            TServer poolServer = new TThreadPoolServer(poolArgs);
            poolServer.serve();*/

        } catch (TTransportException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
