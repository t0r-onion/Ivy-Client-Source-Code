/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Predicate
 *  com.google.common.base.Predicates
 *  com.google.common.collect.Iterators
 *  com.google.common.collect.Lists
 */
package net.minecraft.util;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.IObjectIntIterable;

public class ObjectIntIdentityMap<T>
implements IObjectIntIterable<T> {
    private final IdentityHashMap<T, Integer> identityMap = new IdentityHashMap(512);
    private final List<T> objectList = Lists.newArrayList();

    public void put(T key, int value) {
        this.identityMap.put(key, value);
        while (this.objectList.size() <= value) {
            this.objectList.add(null);
        }
        this.objectList.set(value, key);
    }

    public int get(T key) {
        Integer integer = this.identityMap.get(key);
        return integer == null ? -1 : integer;
    }

    public final T getByValue(int value) {
        return value >= 0 && value < this.objectList.size() ? (T)this.objectList.get(value) : null;
    }

    @Override
    public Iterator<T> iterator() {
        return Iterators.filter(this.objectList.iterator(), (Predicate)Predicates.notNull());
    }
}

