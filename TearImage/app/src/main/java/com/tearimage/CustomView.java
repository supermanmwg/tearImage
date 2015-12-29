package com.tearimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import java.security.cert.PolicyNode;

/**
 * Created by supermanmwg on 15-12-29.
 */
public class CustomView extends ImageView {

    private float top = 0;
    private float bottom = 0;
    private float right = 0;
    private float left = 0;
    private Paint paint;
    private Path path;
    Point leftTop, rightBottom, leftBottom, rightTop;
    private Bitmap clipBitmap;
    private Bitmap drawBitmap;

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        path = new Path();
        clipBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.haha);
        top = getTop();
        bottom = getBottom();
        right = getRight();
        left= getLeft();
        leftTop = new Point((int)left, (int)top);
        rightBottom = new Point((int)(right), (int)bottom);
        leftBottom = new Point((int)left, (int)bottom);
        rightTop = new Point((int)right, (int)top);
        path.moveTo((left + right) / 2, top);
        path.lineTo((left / 4 + 3 * right / 4), (top + bottom) / 2);
        path.lineTo((left + right) / 2, bottom);
        path.lineTo(leftBottom.x, leftBottom.y);
        path.lineTo(leftTop.x, leftTop.y);
        path.lineTo((left + right) / 2, top);
        path.setFillType(Path.FillType.EVEN_ODD);
        path.close();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        canvas.clipPath(path);
        Rect rect = new Rect((int)(left), (int)top, (int)right, (int)bottom);
        canvas.drawBitmap(clipBitmap, rect, rect, paint);

      /*  drawBitmap = Bitmap.createBitmap((int) (left / 4 + 3 * right / 4), (int) bottom, Bitmap.Config.ARGB_4444);
        Canvas canvas1 = new Canvas(drawBitmap);
        canvas1.clipPath(path);
        canvas1.drawBitmap(clipBitmap, rect,rect, paint);
        Log.d("pos ", "top: " + top + ", bottom: " + bottom + ", right: " + right + ", left:" + left);*/
    }

}
