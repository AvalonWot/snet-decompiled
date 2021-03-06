package com.google.android.gms.people.internal.autocomplete;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.people.Autocomplete.Phone;

@Class(creator = "PhoneImplCreator")
public class PhoneImpl implements Phone, SafeParcelable {
    public static final Creator<PhoneImpl> CREATOR;
    private static final int VERSION_CODE = 1;
    @Field(id = 2)
    final String mValue;
    @VersionField(id = 1)
    final int mVersionCode;

    static {
        CREATOR = new PhoneImplCreator();
    }

    @Constructor
    PhoneImpl(@Param(id = 1) int versionCode, @Param(id = 2) String value) {
        this.mVersionCode = versionCode;
        this.mValue = value;
    }

    public PhoneImpl(String value) {
        this(VERSION_CODE, value);
    }

    public CharSequence getValue() {
        return this.mValue;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        PhoneImplCreator.writeToParcel(this, dest, flags);
    }
}
