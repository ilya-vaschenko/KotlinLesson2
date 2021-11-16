// Generated by view binder compiler. Do not edit!
package com.example.kotlinlesson2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.kotlinlesson2.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemFilmBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView date;

  @NonNull
  public final TextView description;

  @NonNull
  public final TextView genre;

  @NonNull
  public final AppCompatImageView imageView;

  @NonNull
  public final CheckBox like;

  @NonNull
  public final TextView title;

  private ItemFilmBinding(@NonNull CardView rootView, @NonNull TextView date,
      @NonNull TextView description, @NonNull TextView genre, @NonNull AppCompatImageView imageView,
      @NonNull CheckBox like, @NonNull TextView title) {
    this.rootView = rootView;
    this.date = date;
    this.description = description;
    this.genre = genre;
    this.imageView = imageView;
    this.like = like;
    this.title = title;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemFilmBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemFilmBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_film, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemFilmBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.date;
      TextView date = ViewBindings.findChildViewById(rootView, id);
      if (date == null) {
        break missingId;
      }

      id = R.id.description;
      TextView description = ViewBindings.findChildViewById(rootView, id);
      if (description == null) {
        break missingId;
      }

      id = R.id.genre;
      TextView genre = ViewBindings.findChildViewById(rootView, id);
      if (genre == null) {
        break missingId;
      }

      id = R.id.imageView;
      AppCompatImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.like;
      CheckBox like = ViewBindings.findChildViewById(rootView, id);
      if (like == null) {
        break missingId;
      }

      id = R.id.title;
      TextView title = ViewBindings.findChildViewById(rootView, id);
      if (title == null) {
        break missingId;
      }

      return new ItemFilmBinding((CardView) rootView, date, description, genre, imageView, like,
          title);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}