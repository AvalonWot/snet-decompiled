package com.google.android.apps.kids.familymanagement;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.wireless.android.play.playlog.proto.ClientAnalytics.LogRequest.LogSource;
import com.google.wireless.android.play.playlog.proto.UserLocation.LaunchSettingsEvent.Action;
import com.google.wireless.android.play.playlog.proto.UserLocation.LocationSharingEvent.Type;
import java.io.IOException;

public final class FamilyManagementExtension extends ExtendableMessageNano<FamilyManagementExtension> {
    private static volatile FamilyManagementExtension[] _emptyArray;
    public FamilyManagementEvent familyManagementEvent;
    public FamilySetupEvent familySetupEvent;

    public static FamilyManagementExtension[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new FamilyManagementExtension[0];
                }
            }
        }
        return _emptyArray;
    }

    public FamilyManagementExtension() {
        clear();
    }

    public FamilyManagementExtension clear() {
        this.familyManagementEvent = null;
        this.familySetupEvent = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof FamilyManagementExtension)) {
            return false;
        }
        FamilyManagementExtension other = (FamilyManagementExtension) o;
        if (this.familyManagementEvent == null) {
            if (other.familyManagementEvent != null) {
                return false;
            }
        } else if (!this.familyManagementEvent.equals(other.familyManagementEvent)) {
            return false;
        }
        if (this.familySetupEvent == null) {
            if (other.familySetupEvent != null) {
                return false;
            }
        } else if (!this.familySetupEvent.equals(other.familySetupEvent)) {
            return false;
        }
        if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
            return this.unknownFieldData.equals(other.unknownFieldData);
        }
        if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + (this.familyManagementEvent == null ? 0 : this.familyManagementEvent.hashCode())) * 31) + (this.familySetupEvent == null ? 0 : this.familySetupEvent.hashCode())) * 31;
        if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
            i = this.unknownFieldData.hashCode();
        }
        return hashCode + i;
    }

    public void writeTo(CodedOutputByteBufferNano output) throws IOException {
        if (this.familyManagementEvent != null) {
            output.writeMessage(1, this.familyManagementEvent);
        }
        if (this.familySetupEvent != null) {
            output.writeMessage(2, this.familySetupEvent);
        }
        super.writeTo(output);
    }

    protected int computeSerializedSize() {
        int size = super.computeSerializedSize();
        if (this.familyManagementEvent != null) {
            size += CodedOutputByteBufferNano.computeMessageSize(1, this.familyManagementEvent);
        }
        if (this.familySetupEvent != null) {
            return size + CodedOutputByteBufferNano.computeMessageSize(2, this.familySetupEvent);
        }
        return size;
    }

    public FamilyManagementExtension mergeFrom(CodedInputByteBufferNano input) throws IOException {
        while (true) {
            int tag = input.readTag();
            switch (tag) {
                case Action.UNKNOWN /*0*/:
                    break;
                case Type.TAP_ABOUT /*10*/:
                    if (this.familyManagementEvent == null) {
                        this.familyManagementEvent = new FamilyManagementEvent();
                    }
                    input.readMessage(this.familyManagementEvent);
                    continue;
                case LogSource.GOOGLE_ANALYTICS /*18*/:
                    if (this.familySetupEvent == null) {
                        this.familySetupEvent = new FamilySetupEvent();
                    }
                    input.readMessage(this.familySetupEvent);
                    continue;
                default:
                    if (!storeUnknownField(input, tag)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public static FamilyManagementExtension parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
        return (FamilyManagementExtension) MessageNano.mergeFrom(new FamilyManagementExtension(), data);
    }

    public static FamilyManagementExtension parseFrom(CodedInputByteBufferNano input) throws IOException {
        return new FamilyManagementExtension().mergeFrom(input);
    }
}
