package jp.hoangvu.navigationexample

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NotifyDao {

    @Query("SELECT * FROM notify_table ORDER BY id ASC")
    fun getListNotify(): LiveData<List<NotifyData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(notifyData: NotifyData)

    @Query("DELETE FROM notify_table WHERE id = :id")
    suspend fun delete(id: Int)
}