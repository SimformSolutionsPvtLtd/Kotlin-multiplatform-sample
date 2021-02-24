//
//  MoviesCell.swift
//  iosApp
//
//  Created by Mohammed Hanif on 20/02/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import UIKit
import shared
import Kingfisher

class MoviesCell: UITableViewCell {
    
    // MARK: - Outlets
    @IBOutlet weak var lblMovieName: UILabel!
    @IBOutlet weak var lblMovieRating: UILabel!
    @IBOutlet weak var lblMovieOverView: UILabel!
    @IBOutlet weak var imgMoviePoster: UIImageView!
    
    // MARK: - SetUp Movie Details
    func setUpMoviesData(movieEntity: MovieEntity) {
        lblMovieName.text = movieEntity.title
        lblMovieRating.text = "\(movieEntity.voteAverage) \(ConstantStrings.votesOutOf)"
        lblMovieOverView.text = movieEntity.overview
        imgMoviePoster.kf.setImage(with: URL(string: movieEntity.picturePoster), placeholder:UIImage(named: ConstantStrings.placeHolderImageName))
    }
    
}
