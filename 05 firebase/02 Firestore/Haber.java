package com.example.okulhaber;

import com.google.firebase.firestore.DocumentId;
import com.google.type.DateTime;

import java.io.Serializable;

public class Haber {
    @DocumentId
    public String id;
    public String baslik;
    public String aciklama;
}
