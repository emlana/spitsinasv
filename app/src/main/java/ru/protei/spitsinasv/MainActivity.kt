package ru.protei.spitsinasv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import ru.protei.spitsinasv.ui.theme.spitsinasvTheme
import ru.protei.spitsinasv.domain.Note

class MainActivity : ComponentActivity() {

    val noteList = listOf(
        Note("Ван Пис", "Прекрасное аниме"),
        Note("Трафальгар Ло", "Имеет имбовый дьявольский фрукт"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            spitsinasvTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    NotesList(noteList)
                }
            }
        }
    }
}

@Composable
fun NotesList(noteList: List<Note>) {
    Column {
        for (note in noteList) {
            NoteItem(note)
        }
    }
}

@Composable
fun NoteItem(note: Note) {
    val styledTitle = buildAnnotatedString {
        withStyle(style = MaterialTheme.typography.titleLarge.toSpanStyle()) {
            append(note.title)
        }
    }

// Отображаем заголовок и текст заметки
    Text(text = styledTitle)
    Text(text = note.text)
    Text(text = "")
}

