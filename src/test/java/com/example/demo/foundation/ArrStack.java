package com.example.demo.foundation;

/**
 *  顺序栈结构
 */
public class ArrStack {
    // 栈的最大容量
    static final int MAXLEN=10;
    // 存储数据
    private String datas[] = new String[MAXLEN];
    // 栈顶位置
    private int top = 0;

    /**
     * 入栈
     * @return
     */
    public boolean PushStack(String data){
        // 判断栈是否满了
        if(top==MAXLEN){
            System.out.println("栈满了，请释放空间");
            return false;
        }else {
            // 数据入栈
            datas[top++] = data;
            return true;
        }
    }

    /**
     * 出栈
     * @return
     */
    public String PopStack(){
        // 判断栈是否为空
        if (top==0){
            System.out.println("栈为空");
            return null;
        }else {
            // 数据出栈
            return datas[--top];
        }
    }

    /**
     * 读取栈顶数据
     * @return
     */
    public String PeekStack(){
        // 判断栈顶是否为空
        if (top==0){
            System.out.println("栈为空");
            return null;
        }else {
            return datas[top-1];
        }
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isNull(){
        return top==0 ? true:false;
    }

    /**
     * 判断栈是否满了
     * @return
     */
    public boolean isFull(){
        return top==MAXLEN ? true:false;
    }

    /**
     * 获取栈数据的大小
     * @return
     */
    public int size(){
        return top;
    }

    public static void main(String[] args) {
        // 创建栈
        ArrStack stack = new ArrStack();
        // 判断栈空
        System.out.println(stack.isNull());
        // 入栈
        stack.PushStack("数据1");
        // 查看栈顶数据
        System.out.println(stack.PeekStack());
        // 再次入栈
        stack.PushStack("数据2");
        stack.PushStack("数据3");
        // 查看栈顶数据
        System.out.println(stack.PeekStack());
        // 出栈
        stack.PopStack();
        // 查看栈顶数据
        System.out.println(stack.PeekStack());
        // 查看栈的大小
        System.out.println(stack.size());
    }
}
