package com.quzzar.dominions.Addons;

import com.badlogic.gdx.Gdx;
import com.quzzar.dominions.Fonts.FontType;
import com.quzzar.dominions.Fonts.Font;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ToastController {

    private static final List<Toast> toasts = new LinkedList<Toast>();
    private static Toast.ToastFactory toastFactory;

    public static void initialize() {
        toastFactory = new Toast.ToastFactory.Builder()
                .font(Font.getFont(FontType.AK_SANS,0.7f))
                .build();
    }

    public static void displayLong(String text) {
        toasts.add(toastFactory.create(text, Toast.Length.SHORT));
    }

    public static void displayShort(String text) {
        toasts.add(toastFactory.create(text, Toast.Length.SHORT));
    }

    public static void render() {
        Iterator<Toast> it = toasts.iterator();
        while(it.hasNext()) {
            Toast t = it.next();
            if (!t.render(Gdx.graphics.getDeltaTime())) {
                it.remove();
            } else {
                break;
            }
        }
    }
}