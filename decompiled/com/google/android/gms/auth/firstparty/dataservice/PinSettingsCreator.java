package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.wireless.android.play.playlog.proto.UserLocation.LocationSharingEvent;
import com.google.wireless.android.play.playlog.proto.UserLocation.OvenFreshEvent.OvenFreshResult;
import com.google.wireless.android.play.playlog.proto.UserLocation.TimeSelection.Type;

public class PinSettingsCreator implements Creator<PinSettings> {
    public static final int CONTENT_DESCRIPTION = 0;

    public PinSettings createFromParcel(Parcel parcel) {
        int end = SafeParcelReader.validateObjectHeader(parcel);
        int _local_safe_0a1b_version = 0;
        String _local_safe_0a1b_status = null;
        String _local_safe_0a1b_resetUrl = null;
        String _local_safe_0a1b_setupUrl = null;
        String _local_safe_0a1b_recoveryUrl = null;
        int _local_safe_0a1b_length = 0;
        while (parcel.dataPosition() < end) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case Type.TEMPORARY /*1*/:
                    _local_safe_0a1b_version = SafeParcelReader.readInt(parcel, header);
                    break;
                case Type.INDEFINITELY /*2*/:
                    _local_safe_0a1b_status = SafeParcelReader.createString(parcel, header);
                    break;
                case Type.CUSTOM /*3*/:
                    _local_safe_0a1b_resetUrl = SafeParcelReader.createString(parcel, header);
                    break;
                case OvenFreshResult.NO_ACCOUNTS /*4*/:
                    _local_safe_0a1b_setupUrl = SafeParcelReader.createString(parcel, header);
                    break;
                case LocationSharingEvent.Type.ADD_NEW_SHARES /*5*/:
                    _local_safe_0a1b_length = SafeParcelReader.readInt(parcel, header);
                    break;
                case LocationSharingEvent.Type.REMOVE_SHARE /*6*/:
                    _local_safe_0a1b_recoveryUrl = SafeParcelReader.createString(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        if (parcel.dataPosition() == end) {
            return new PinSettings(_local_safe_0a1b_version, _local_safe_0a1b_status, _local_safe_0a1b_resetUrl, _local_safe_0a1b_setupUrl, _local_safe_0a1b_recoveryUrl, _local_safe_0a1b_length);
        }
        throw new ParseException("Overread allowed size end=" + end, parcel);
    }

    public PinSettings[] newArray(int size) {
        return new PinSettings[size];
    }

    static void writeToParcel(PinSettings obj, Parcel parcel, int flags) {
        int myStart = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, obj.version);
        SafeParcelWriter.writeString(parcel, 2, obj.status, false);
        SafeParcelWriter.writeString(parcel, 3, obj.resetUrl, false);
        SafeParcelWriter.writeString(parcel, 4, obj.setupUrl, false);
        SafeParcelWriter.writeInt(parcel, 5, obj.length);
        SafeParcelWriter.writeString(parcel, 6, obj.recoveryUrl, false);
        SafeParcelWriter.finishObjectHeader(parcel, myStart);
    }
}
