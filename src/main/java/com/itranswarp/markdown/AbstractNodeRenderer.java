package com.itranswarp.markdown;
import java.util.Set;
import org.commonmark.node.Node;
import org.commonmark.renderer.NodeRenderer;
import org.commonmark.renderer.html.HtmlNodeRendererContext;


public abstract class AbstractNodeRenderer implements NodeRenderer {

    protected final HtmlNodeRendererContext context;


    protected AbstractNodeRenderer(HtmlNodeRendererContext context) {
        this.context = context;
    }

    protected void visitChildren(Node parent) {
        Node node = parent.getFirstChild();
        while (node != null) {
            Node next = node.getNext();
            context.render(node);
            node = next;
        }
    }

    // Abstract methods to be implemented by subclasses
    @Override
    public abstract Set<Class<? extends Node>> getNodeTypes();

    @Override
    public abstract void render(Node node);
}
