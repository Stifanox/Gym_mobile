package com.example.gym.cycle_feature.ui.screens.cycle_add_screen.view_models

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.gym.data.database.model.TrainingCycleDatabase
import com.example.gym.domain.repository.database.CyclesRepositoryDatabase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException


@HiltWorker
class SaveToDatabaseWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted private val params: WorkerParameters,
    private val cyclesRepositoryDatabase: CyclesRepositoryDatabase
) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO) {
            val nameOfCycle = inputData.getString(KEY_NAME_OF_CYCLE)
            val id = inputData.getInt(KEY_ID_OF_USER, 0)
            if (nameOfCycle.isNullOrEmpty()) return@withContext Result.failure()
            try {
                cyclesRepositoryDatabase.addNewCycle(TrainingCycleDatabase(0, id, nameOfCycle))
                Result.success()

            } catch (e: IOException) {
                Result.failure()
            }
        }
    }

    companion object {
        const val KEY_NAME_OF_CYCLE = "KEY_NAME_OF_CYCLE"
        const val KEY_ID_OF_USER = "KEY_ID_OF_USER"
    }

}